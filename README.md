# 🖥️ Full Stack Engineering (FSE) — Exercise Solutions

A comprehensive collection of hands-on exercises and solutions covering the full web and Java development stack. This repository is organized by technology module, following a structured learning path from frontend basics to backend Java and database programming.

---

## 📁 Repository Structure

```
FSE/
├── Module_1/
│   ├── HTML5/           # Local Community Event Portal — markup exercises
│   ├── CSS3/            # Styling the Event Portal
│   ├── JavaScript/      # Dynamic interactions for the Event Portal
│   └── Bootstrap5/      # Responsive UI components
├── Module_2/
│   └── SQL/             # ANSI SQL using MySQL — Event management schema & queries
└── Module_3/
    └── CoreJava/        # Java fundamentals through advanced topics
```

---

## 📚 Modules Overview

### Module 1 — Frontend Development

All frontend exercises are themed around a **Local Community Event Portal** — a browser-based portal for residents to browse events, register, and access community services.

---

#### 🌐 HTML5

> **File:** `Module_1/HTML5/`

| # | Exercise | Key Concepts |
|---|----------|--------------|
| 1 | HTML5 Base Template | `<!DOCTYPE html>`, semantic structure, Chrome DevTools |
| 2 | Navigation and Linking | `<nav>`, anchor tags, section IDs, external links |
| 3 | Welcome Message | `<div>`, `<span>`, inline vs internal CSS, `id` vs `class` |
| 4 | Image Gallery | `<table>`, `<img>`, `alt`, `title`, captions |
| 5 | Event Registration Form | `<form>`, input types, `placeholder`, `required`, `<output>` |
| 6 | Event Feedback & Event Handling | `onblur`, `onchange`, `onclick`, `ondblclick`, keyboard events |
| 7 | Video Invite with Media Events | `<video>`, `oncanplay`, `onbeforeunload` |
| 8 | Saving User Preferences | `localStorage`, `sessionStorage`, clearing preferences |
| 9 | Geolocation for Event Mapping | `getCurrentPosition()`, error handling, high-accuracy options |
| 10 | Debugging with Chrome DevTools | Inspect element, Console tab, breakpoints |

---

#### 🎨 CSS3

> **File:** `Module_1/CSS3/`

| # | Exercise | Key Concepts |
|---|----------|--------------|
| 1 | Inline vs Internal vs External CSS | Style methods, comments, `styles.css` |
| 2 | CSS Syntax and Comments | Clean formatting, structured stylesheets |
| 3 | Selectors Playground | Universal, element, ID, class, grouping selectors |
| 4 | Color & Background Styling | HEX, RGBA, background images, `linear-gradient()` |
| 5 | Typography | Google Fonts, `font-family`, `text-align`, `letter-spacing` |
| 6 | Link and List Styling | `:link`, `:hover`, `:visited`, `list-style-type` |
| 7 | Table Styling | `border-collapse`, zebra striping with `nth-child(even)` |
| 8 | Box Model & Layout Control | `margin`, `padding`, `border`, `outline`, `visibility` vs `display` |
| 9 | Multi-Column Text Layout | `column-count`, `column-gap`, `column-rule` |
| 10 | Responsive Design with Media Queries | `@media`, Flexbox, Grid, `vw`, `vh`, `%` units |
| 11 | Debug with DevTools | Device toolbar, live style editing, Network tab |

---

#### ⚡ JavaScript

> **File:** `Module_1/JavaScript/`

| # | Exercise | Key Concepts |
|---|----------|--------------|
| 1 | JS Basics & Setup | `<script>`, `console.log()`, `alert()` |
| 2 | Data Types and Operators | `const`, `let`, template literals, `++`/`--` |
| 3 | Conditionals, Loops & Error Handling | `if-else`, `forEach()`, `try-catch` |
| 4 | Functions, Scope & Closures | HOFs, closures, callbacks, `filterEventsByCategory()` |
| 5 | Objects and Prototypes | Constructors, prototype methods, `Object.entries()` |
| 6 | Arrays and Methods | `.push()`, `.filter()`, `.map()` |
| 7 | DOM Manipulation | `querySelector()`, `createElement()`, dynamic rendering |
| 8 | Event Handling | `onclick`, `onchange`, `keydown` |
| 9 | Async JS, Promises & Async/Await | `fetch()`, `.then()/.catch()`, loading spinner |
| 10 | Modern JS Features | Destructuring, spread operator, default parameters |
| 11 | Working with Forms | `form.elements`, `preventDefault()`, inline validation |
| 12 | AJAX & Fetch API | `fetch()` POST, `setTimeout()`, success/failure handling |
| 13 | Debugging and Testing | DevTools Console, Network tab, breakpoints |
| 14 | jQuery & JS Frameworks | `$('#id').click()`, `.fadeIn()`, `.fadeOut()`, intro to React/Vue |

---

#### 📱 Bootstrap 5

> **File:** `Module_1/Bootstrap5/`

| # | Exercise | Key Concepts |
|---|----------|--------------|
| 1 | Setting Up Bootstrap 5 | CDN link, npm/downloaded setup |
| 2 | Bootstrap Structure & Files | CSS/JS/icons folders, `bootstrap.bundle.min.js` |
| 3 | Responsive Grid Layout | `.container`, `.row`, `.col-*` breakpoints |
| 4 | Column Layouts | Sidebar (`col-md-3`), content (`col-md-9`), 4-column grid |
| 5 | Alignment and Reordering | `justify-content-center`, `order-md-*` |
| 6 | Responsive Flexbox Utilities | `d-flex`, `flex-column`, `flex-md-row`, `justify-content-between` |
| 7 | Typography | `display-1`, `lead`, `text-muted`, `fw-bold`, `text-uppercase` |
| 8 | Forms | `form-control`, `form-check`, `input-group`, `form-floating` |
| 9 | Buttons | `btn-primary`, `btn-outline-*`, `btn-group`, toggle buttons |
| 10 | Navbars and Navigation | Responsive navbar, `nav-tabs`, `nav-pills` |
| 11 | Cards and Media Objects | `card`, `card-body`, `card-img-top`, media layout |
| 12 | Spacing Utilities | `m-3`, `mt-4`, `p-2`, `py-5` |
| 13 | Colors and Backgrounds | `bg-primary`, `bg-gradient`, contextual text colors |
| 14 | Display and Visibility | `d-none`, `d-md-block`, `d-lg-flex`, responsive sidebar |
| 15 | Borders, Shadows & Rounded Corners | `border-primary`, `rounded-circle`, `shadow-lg`, `rounded-pill` |
| 16 | Positioning Utilities | `position-fixed`, `position-absolute`, badge overlay |
| 17 | Icons with Bootstrap Icons | Social media icons, icon-only buttons |
| 18 | JavaScript Plugins | Modal popup, collapsible accordion |
| 19 | Customization with Sass | `_variables.scss`, recompiling Bootstrap, custom colors |

---

### Module 2 — Database Programming

#### 🗄️ ANSI SQL Using MySQL

> **File:** `Module_2/SQL/`

**Database Schema — Event Management System**

The exercises use a normalized relational schema with 6 tables:

| Table | Description |
|-------|-------------|
| `Users` | Registered portal users with city and registration date |
| `Events` | Community events with status (`upcoming`, `completed`, `cancelled`) |
| `Sessions` | Individual sessions within events, with speaker info |
| `Registrations` | User–event registration mapping |
| `Feedback` | Ratings (1–5) and comments from users for events |
| `Resources` | PDFs, images, and links attached to events |

**Exercises**

| # | Query | Concepts |
|---|-------|----------|
| 1 | User Upcoming Events | `JOIN`, `WHERE`, `ORDER BY` |
| 2 | Top Rated Events | `AVG()`, `HAVING`, `GROUP BY` |
| 3 | Inactive Users | `NOT IN`, `DATE_SUB()`, subqueries |
| 4 | Peak Session Hours | `TIME()`, `COUNT()`, `BETWEEN` |
| 5 | Most Active Cities | `COUNT(DISTINCT)`, `LIMIT` |
| 6 | Event Resource Summary | `GROUP BY`, `SUM(CASE WHEN ...)` |
| 7 | Low Feedback Alerts | `JOIN`, `WHERE rating < 3` |
| 8 | Sessions per Upcoming Event | `LEFT JOIN`, `COUNT()` |
| 9 | Organizer Event Summary | `GROUP BY`, `COUNT()`, `status` |
| 10 | Feedback Gap | `LEFT JOIN ... WHERE IS NULL` |
| 11 | Daily New User Count | `DATE()`, `GROUP BY`, `DATEDIFF` |
| 12 | Event with Maximum Sessions | `HAVING MAX()`, subquery |
| 13 | Average Rating per City | `AVG()`, `JOIN`, `GROUP BY city` |
| 14 | Most Registered Events | `COUNT()`, `ORDER BY`, `LIMIT 3` |
| 15 | Event Session Time Conflict | Self-join on overlapping time ranges |
| 16 | Unregistered Active Users | `NOT EXISTS`, `DATE_SUB()` |
| 17 | Multi-Session Speakers | `COUNT()`, `HAVING COUNT > 1` |
| 18 | Resource Availability Check | `LEFT JOIN ... WHERE IS NULL` |
| 19 | Completed Events with Feedback Summary | `WHERE status='completed'`, `AVG()` |
| 20 | User Engagement Index | Multi-table `JOIN`, `COUNT()` |
| 21 | Top Feedback Providers | `COUNT()`, `ORDER BY DESC`, `LIMIT 5` |
| 22 | Duplicate Registrations Check | `GROUP BY`, `HAVING COUNT > 1` |
| 23 | Registration Trends | `MONTH()`, `YEAR()`, `GROUP BY` |
| 24 | Average Session Duration per Event | `TIMESTAMPDIFF(MINUTE, ...)` |
| 25 | Events Without Sessions | `LEFT JOIN ... WHERE IS NULL` |

---

### Module 3 — Core Java

> **File:** `Module_3/CoreJava/`

| # | Exercise | Concepts Covered |
|---|----------|-----------------|
| 1 | Hello World | Java program structure, `System.out.println()` |
| 2 | Simple Calculator | Arithmetic, `Scanner`, user input |
| 3 | Even or Odd Checker | Modulus operator, conditionals |
| 4 | Leap Year Checker | Nested conditionals, divisibility logic |
| 5 | Multiplication Table | `for` loop |
| 6 | Data Type Demonstration | Primitive types: `int`, `float`, `double`, `char`, `boolean` |
| 7 | Type Casting | Implicit and explicit casting |
| 8 | Operator Precedence | Expression evaluation, order of operations |
| 9 | Grade Calculator | `if-else` chains |
| 10 | Number Guessing Game | `Random`, loops, conditionals |
| 11 | Factorial Calculator | `for` loop, accumulator pattern |
| 12 | Method Overloading | Same method name, different parameters |
| 13 | Recursive Fibonacci | Recursion, base case |
| 14 | Array Sum and Average | Arrays, iteration, arithmetic |
| 15 | String Reversal | `StringBuilder`, loops |
| 16 | Palindrome Checker | String manipulation, regex, comparison |
| 17 | Class and Object Creation | OOP, attributes, methods, instantiation |
| 18 | Inheritance | `extends`, method overriding |
| 19 | Interface Implementation | `interface`, `implements`, polymorphism |
| 20 | Try-Catch | Exception handling, `ArithmeticException` |
| 21 | Custom Exception | `throws`, custom `Exception` subclass |
| 22 | File Writing | `FileWriter`, `PrintWriter`, `output.txt` |
| 23 | File Reading | `BufferedReader`, `FileReader` |
| 24 | ArrayList | `ArrayList<String>`, dynamic sizing |
| 25 | HashMap | `HashMap<Integer, String>`, key-value access |
| 26 | Thread Creation | `Thread`, `Runnable`, `start()`, `run()` |
| 27 | Lambda Expressions | `Collections.sort()`, functional interface |
| 28 | Stream API | `.filter()`, `.collect()`, stream pipeline |
| 29 | Records (Java 16+) | `record`, immutable data, streams |
| 30 | Pattern Matching for switch (Java 21) | Enhanced `switch`, type patterns |
| 31 | Basic JDBC Connection | JDBC driver, `Connection`, `SELECT` |
| 32 | Insert & Update via JDBC | `PreparedStatement`, `StudentDAO` |
| 33 | Transaction Handling in JDBC | `setAutoCommit(false)`, commit/rollback |
| 34 | Java Modules | `module-info.java`, `exports`, module path |
| 35 | TCP Client-Server Chat | `ServerSocket`, `InputStream`, `OutputStream` |
| 36 | HTTP Client API (Java 11+) | `HttpClient`, `HttpRequest`, JSON parsing |
| 37 | Inspect Bytecode with `javap` | `javap -c`, bytecode analysis |
| 38 | Decompile a Class File | JD-GUI / CFR decompiler |
| 39 | Reflection in Java | `Class.forName()`, `getDeclaredMethods()`, `invoke()` |
| 40 | Virtual Threads (Java 21) | `Thread.startVirtualThread()`, performance |
| 41 | Executor Service and Callable | `ExecutorService`, `Callable`, `Future.get()` |

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Markup | HTML5 |
| Styling | CSS3, Bootstrap 5 |
| Frontend Logic | JavaScript (ES6+), jQuery |
| Database | MySQL (ANSI SQL) |
| Backend | Core Java (Java 11–21) |
| DB Connectivity | JDBC |
| Build/Tools | `javac`, `javap`, Maven (optional) |

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 21+
- MySQL 8.x
- A modern browser (Chrome recommended for DevTools)
- VS Code or IntelliJ IDEA
- Node.js (optional, for Bootstrap Sass customization)

### Running Java Exercises

```bash
# Compile
javac Module_3/CoreJava/HelloWorld.java

# Run
java HelloWorld
```

### Setting Up the MySQL Database

```sql
-- Run the schema setup script
SOURCE Module_2/SQL/schema.sql;

-- Populate sample data
SOURCE Module_2/SQL/seed.sql;

-- Run individual exercise queries
SOURCE Module_2/SQL/exercises.sql;
```

### Viewing Frontend Exercises

Open any `.html` file directly in Chrome, or use VS Code's Live Server extension for hot-reload during development.

---

## 📝 Notes

- Java exercises 29–41 require **Java 16+** (records) and **Java 21** (virtual threads, pattern matching for switch).
- JDBC exercises (31–33) require a running MySQL instance and the appropriate JDBC driver on the classpath.
- Frontend exercises use only vanilla HTML/CSS/JS — no build step required unless customizing Bootstrap with Sass (Exercise 19).

---

## 👤 Author

**Abhinav Saxena**  
[GitHub](https://github.com/AbhinavSaxena-spec)
