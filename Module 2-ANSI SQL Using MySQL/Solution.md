# ANSI SQL Using MySQL — Exercise Solutions

---

## Database Schema

| Table | Key Columns |
|-------|------------|
| `Users` | user_id, full_name, email, city, registration_date |
| `Events` | event_id, title, city, start_date, end_date, status, organizer_id |
| `Sessions` | session_id, event_id, title, speaker_name, start_time, end_time |
| `Registrations` | registration_id, user_id, event_id, registration_date |
| `Feedback` | feedback_id, user_id, event_id, rating (1–5), comments, feedback_date |
| `Resources` | resource_id, event_id, resource_type (pdf/image/link), resource_url, uploaded_at |

---

## Solutions

### Q1 — User Upcoming Events
> Show a list of all upcoming events a user is registered for in their city, sorted by date.

```sql
SELECT u.full_name, e.title, e.city, e.start_date, e.end_date
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
JOIN Events e        ON r.event_id = e.event_id
WHERE e.status = 'upcoming'
  AND e.city = u.city
ORDER BY e.start_date ASC;
```

---

### Q2 — Top Rated Events
> Identify events with the highest average rating, considering only those with at least 10 feedback submissions.

```sql
SELECT e.event_id, e.title,
       AVG(f.rating)        AS avg_rating,
       COUNT(f.feedback_id) AS total_feedback
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(f.feedback_id) >= 10
ORDER BY avg_rating DESC;
```

---

### Q3 — Inactive Users
> Retrieve users who have not registered for any events in the last 90 days.

```sql
SELECT u.user_id, u.full_name, u.email
FROM Users u
WHERE u.user_id NOT IN (
    SELECT DISTINCT user_id
    FROM Registrations
    WHERE registration_date >= CURDATE() - INTERVAL 90 DAY
);
```

---

### Q4 — Peak Session Hours
> Count how many sessions are scheduled between 10 AM and 12 PM for each event.

```sql
SELECT e.event_id, e.title,
       COUNT(s.session_id) AS sessions_in_peak
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
WHERE TIME(s.start_time) >= '10:00:00'
  AND TIME(s.start_time) <  '12:00:00'
GROUP BY e.event_id, e.title;
```

---

### Q5 — Most Active Cities
> List the top 5 cities with the highest number of distinct user registrations.

```sql
SELECT e.city,
       COUNT(DISTINCT r.user_id) AS unique_registrations
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
GROUP BY e.city
ORDER BY unique_registrations DESC
LIMIT 5;
```

---

### Q6 — Event Resource Summary
> Generate a report showing the number of resources (PDFs, images, links) uploaded for each event.

```sql
SELECT e.event_id, e.title,
       COUNT(r.resource_id)            AS total_resources,
       SUM(r.resource_type = 'pdf')    AS pdfs,
       SUM(r.resource_type = 'image')  AS images,
       SUM(r.resource_type = 'link')   AS links
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title;
```

---

### Q7 — Low Feedback Alerts
> List all users who gave feedback with a rating less than 3, along with their comments and associated event names.

```sql
SELECT u.full_name, u.email,
       e.title AS event_name,
       f.rating, f.comments, f.feedback_date
FROM Feedback f
JOIN Users  u ON f.user_id  = u.user_id
JOIN Events e ON f.event_id = e.event_id
WHERE f.rating < 3
ORDER BY f.rating ASC;
```

---

### Q8 — Sessions per Upcoming Event
> Display all upcoming events with the count of sessions scheduled for them.

```sql
SELECT e.event_id, e.title, e.start_date,
       COUNT(s.session_id) AS session_count
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title, e.start_date
ORDER BY e.start_date;
```

---

### Q9 — Organizer Event Summary
> For each event organizer, show the number of events created and their current status breakdown.

```sql
SELECT u.user_id, u.full_name,
       COUNT(e.event_id)             AS total_events,
       SUM(e.status = 'upcoming')    AS upcoming,
       SUM(e.status = 'completed')   AS completed,
       SUM(e.status = 'cancelled')   AS cancelled
FROM Users u
JOIN Events e ON u.user_id = e.organizer_id
GROUP BY u.user_id, u.full_name;
```

---

### Q10 — Feedback Gap
> Identify events that had registrations but received no feedback at all.

```sql
SELECT e.event_id, e.title
FROM Events e
WHERE e.event_id IN (
        SELECT DISTINCT event_id FROM Registrations
      )
  AND e.event_id NOT IN (
        SELECT DISTINCT event_id FROM Feedback
      );
```

---

### Q11 — Daily New User Count
> Find the number of users who registered each day in the last 7 days.

```sql
SELECT registration_date,
       COUNT(*) AS new_users
FROM Users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date
ORDER BY registration_date;
```

---

### Q12 — Event with Maximum Sessions
> List the event(s) with the highest number of sessions.

```sql
SELECT e.event_id, e.title,
       COUNT(s.session_id) AS session_count
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(s.session_id) = (
    SELECT MAX(cnt)
    FROM (
        SELECT COUNT(session_id) AS cnt
        FROM Sessions
        GROUP BY event_id
    ) AS t
);
```

---

### Q13 — Average Rating per City
> Calculate the average feedback rating of events conducted in each city.

```sql
SELECT e.city,
       ROUND(AVG(f.rating), 2) AS avg_rating,
       COUNT(f.feedback_id)    AS total_feedback
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.city
ORDER BY avg_rating DESC;
```

---

### Q14 — Most Registered Events
> List top 3 events based on the total number of user registrations.

```sql
SELECT e.event_id, e.title,
       COUNT(r.registration_id) AS total_registrations
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY total_registrations DESC
LIMIT 3;
```

---

### Q15 — Event Session Time Conflict
> Identify overlapping sessions within the same event.

```sql
SELECT a.event_id,
       a.session_id AS session_a, a.title AS title_a,
       b.session_id AS session_b, b.title AS title_b,
       a.start_time, a.end_time,
       b.start_time AS b_start,  b.end_time AS b_end
FROM Sessions a
JOIN Sessions b
  ON  a.event_id   = b.event_id
  AND a.session_id < b.session_id
  AND a.start_time < b.end_time
  AND a.end_time   > b.start_time;
```

> **Note:** The overlap condition `a.start_time < b.end_time AND a.end_time > b.start_time` is the standard interval-overlap test. Using `a.session_id < b.session_id` avoids duplicate pairs.

---

### Q16 — Unregistered Active Users
> Find users who created an account in the last 30 days but haven't registered for any events.

```sql
SELECT u.user_id, u.full_name, u.email, u.registration_date
FROM Users u
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
  AND u.user_id NOT IN (
        SELECT DISTINCT user_id FROM Registrations
      );
```

---

### Q17 — Multi-Session Speakers
> Identify speakers who are handling more than one session across all events.

```sql
SELECT speaker_name,
       COUNT(session_id) AS session_count
FROM Sessions
GROUP BY speaker_name
HAVING COUNT(session_id) > 1
ORDER BY session_count DESC;
```

---

### Q18 — Resource Availability Check
> List all events that do not have any resources uploaded.

```sql
SELECT e.event_id, e.title, e.status
FROM Events e
WHERE e.event_id NOT IN (
    SELECT DISTINCT event_id FROM Resources
);
```

---

### Q19 — Completed Events with Feedback Summary
> For completed events, show total registrations and average feedback rating.

```sql
SELECT e.event_id, e.title,
       COUNT(DISTINCT r.registration_id) AS total_registrations,
       ROUND(AVG(f.rating), 2)           AS avg_rating
FROM Events e
LEFT JOIN Registrations r ON e.event_id = r.event_id
LEFT JOIN Feedback      f ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.title;
```

---

### Q20 — User Engagement Index
> For each user, calculate how many events they attended and how many feedbacks they submitted.

```sql
SELECT u.user_id, u.full_name,
       COUNT(DISTINCT r.event_id)    AS events_attended,
       COUNT(DISTINCT f.feedback_id) AS feedbacks_given
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
LEFT JOIN Feedback      f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY events_attended DESC, feedbacks_given DESC;
```

---

### Q21 — Top Feedback Providers
> List top 5 users who have submitted the most feedback entries.

```sql
SELECT u.user_id, u.full_name,
       COUNT(f.feedback_id) AS total_feedback
FROM Users u
JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY total_feedback DESC
LIMIT 5;
```

---

### Q22 — Duplicate Registrations Check
> Detect if a user has been registered more than once for the same event.

```sql
SELECT user_id, event_id,
       COUNT(*) AS duplicate_count
FROM Registrations
GROUP BY user_id, event_id
HAVING COUNT(*) > 1;
```

---

### Q23 — Registration Trends
> Show a month-wise registration count trend over the past 12 months.

```sql
SELECT DATE_FORMAT(registration_date, '%Y-%m') AS month,
       COUNT(*)                                 AS registrations
FROM Registrations
WHERE registration_date >= CURDATE() - INTERVAL 12 MONTH
GROUP BY month
ORDER BY month;
```

---

### Q24 — Average Session Duration per Event
> Compute the average duration (in minutes) of sessions in each event.

```sql
SELECT e.event_id, e.title,
       ROUND(AVG(
           TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)
       ), 2) AS avg_duration_minutes
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title;
```

---

### Q25 — Events Without Sessions
> List all events that currently have no sessions scheduled under them.

```sql
SELECT e.event_id, e.title, e.status, e.start_date
FROM Events e
WHERE e.event_id NOT IN (
    SELECT DISTINCT event_id FROM Sessions
)
ORDER BY e.start_date;
```

---
