/* ============================================================
   main.js — CivicHub Community Event Portal
   Covers: JavaScript Exercises 1–14 + HTML5 JS Exercises
   ============================================================ */

// ============================================================
// JS Exercise 1: Setup — console.log + alert on load
// ============================================================
console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
  alert("Welcome! The CivicHub Community Portal has loaded. 🏛️");
  loadPreferences();       // HTML5 Exercise 8: localStorage restore
  displayEvents(events);   // JS Exercise 7: render DOM
  updatePrefDisplay();
});

// ============================================================
// JS Exercise 2: Data Types, const/let, template literals
// ============================================================
const PORTAL_NAME = "CivicHub";
const LAUNCH_DATE  = "2025-01-01";

// JS Exercise 5: Class + prototype
class Event {
  constructor(id, name, date, category, location, seats, fee) {
    this.id         = id;
    this.name       = name;
    this.date       = date;
    this.category   = category;
    this.location   = location;
    this.seats      = seats;
    this.fee        = fee;
    this.registered = 0;
  }

  // JS Exercise 5: prototype method
  checkAvailability() {
    return this.seats - this.registered > 0;
  }

  // JS Exercise 2: template literal
  getSummary() {
    return `${this.name} | ${this.date} | ${this.category} | Seats left: ${this.seats - this.registered}`;
  }
}

// JS Exercise 6: Array of events
let events = [
  new Event(1, "Music Night",         "2025-07-10", "music",    "City Amphitheater",   30, "Free"),
  new Event(2, "Baking Workshop",     "2025-07-15", "workshop", "Community Kitchen",   15, "₹150"),
  new Event(3, "Community Sports Day","2025-07-20", "sports",   "Riverside Ground",    50, "Free"),
  new Event(4, "Culture Fest",        "2025-07-25", "culture",  "Town Hall",           40, "₹100"),
  new Event(5, "Yoga in the Park",    "2025-08-01", "sports",   "Green Park",          25, "Free"),
  new Event(6, "Coding Bootcamp",     "2025-08-10", "workshop", "Tech Hub",            20, "₹200"),
  new Event(7, "Folk Dance Evening",  "2025-08-12", "culture",  "Heritage Square",     35, "₹80"),
  new Event(8, "Jazz by the Lake",    "2025-08-18", "music",    "Lake Front",          45, "Free"),
];

// JS Exercise 5: Object.entries
console.log("Event keys & values:", Object.entries(events[0]));

// ============================================================
// JS Exercise 4: Closure — category registration tracker
// ============================================================
function makeCategoryTracker() {
  const counts = {};
  return {
    increment(cat) { counts[cat] = (counts[cat] || 0) + 1; },
    getCount(cat)  { return counts[cat] || 0; },
    getAll()       { return { ...counts }; }
  };
}
const categoryTracker = makeCategoryTracker();

// ============================================================
// JS Exercise 3 + 7: Conditionals, loops, DOM rendering
// ============================================================
function displayEvents(eventList) {
  const container = document.getElementById("eventContainer");
  if (!container) return;
  container.innerHTML = "";

  // JS Exercise 3: forEach loop + if-else to skip past/full events
  eventList.forEach(ev => {
    const eventDate = new Date(ev.date);
    const today     = new Date();
    if (eventDate < today)      return;   // skip past
    if (!ev.checkAvailability()) return;  // skip full

    // JS Exercise 7: createElement + append
    const card = document.createElement("div");
    card.className     = "eventCard";
    card.dataset.category = ev.category;
    card.dataset.id       = ev.id;

    // JS Exercise 6: .map() to format display
    card.innerHTML = `
      <span class="event-category-badge">${ev.category}</span>
      <h3>${ev.name}</h3>
      <p>${ev.date}</p>
      <p>${ev.location}</p>
      <p><strong>${ev.fee}</strong></p>
      <p class="seats-badge">🎟 ${ev.seats - ev.registered} seats left</p>
      <div class="event-actions">
        <button class="btn-register" onclick="registerForEvent(${ev.id})">Register</button>
        <button class="btn-cancel"   onclick="cancelEvent(${ev.id})">Cancel</button>
      </div>
    `;
    container.appendChild(card);

    // JS Exercise 14: fadeIn effect (jQuery equivalent via CSS transition)
    card.style.opacity    = "0";
    card.style.transition = "opacity 0.35s ease";
    setTimeout(() => { card.style.opacity = "1"; }, 30);
  });

  if (!container.children.length) {
    container.innerHTML = `<p style="color:var(--text-muted);grid-column:1/-1;padding:2rem 0">No upcoming events match your filter.</p>`;
  }
}

// ============================================================
// JS Exercise 3 + 4: registerUser with try-catch + closure
// JS Exercise 2: ++ operator
// ============================================================
function registerForEvent(id) {
  try {
    const ev = events.find(e => e.id === id);
    if (!ev) throw new Error("Event not found.");
    if (!ev.checkAvailability()) throw new Error("Sorry, this event is full!");

    ev.registered++;                              // Exercise JS#2: ++
    categoryTracker.increment(ev.category);       // Exercise JS#4: closure

    console.log(`Registered: ${ev.getSummary()}`);
    console.log("Category totals:", categoryTracker.getAll());

    displayEvents(events);                        // Exercise JS#7: update UI
    alert(`Registered for "${ev.name}"!\nFee: ${ev.fee}`);
  } catch (err) {
    alert(`Registration failed: ${err.message}`);
    console.error(err);
  }
}

function cancelEvent(id) {
  const ev = events.find(e => e.id === id);
  if (!ev || ev.registered === 0) { alert("Nothing to cancel."); return; }
  ev.registered--;
  displayEvents(events);
  alert(`Registration for "${ev.name}" cancelled.`);
}

// ============================================================
// JS Exercise 4 + 6 + 8: Higher-order filter + spread + onchange
// ============================================================
function filterByCategory() {
  const selected = document.getElementById("categoryFilter").value;
  const cloned   = [...events]; // Exercise JS#10: spread
  const filtered = selected === "all"
    ? cloned
    : filterEventsByCategory(cloned, cat => cat === selected); // Exercise JS#4: callback
  displayEvents(filtered);
}

function filterEventsByCategory(list, categoryFn) {
  return list.filter(ev => categoryFn(ev.category)); // Exercise JS#4
}

// Exercise JS#8: keydown quick search
function quickSearch(e) {
  const query    = e.target.value.toLowerCase();
  const filtered = events.filter(ev =>
    ev.name.toLowerCase().includes(query) ||
    ev.category.toLowerCase().includes(query)
  );
  displayEvents(filtered);
}

// Exercise JS#6: addEvent using .push()
function addEvent(name, date, category, location, seats, fee) {
  const id   = events.length + 1;
  const newEv = new Event(id, name, date, category, location, seats, fee);
  events.push(newEv);
  displayEvents(events);
  return newEv;
}

// ============================================================
// JS Exercise 11: Form handling + preventDefault + validation
// ============================================================
function handleRegistration(e) {
  e.preventDefault(); // Exercise JS#11

  const name      = document.getElementById("fullName").value.trim();
  const email     = document.getElementById("email").value.trim();
  const eventType = document.getElementById("eventType").value;
  const date      = document.getElementById("eventDate").value;

  document.getElementById("nameError").textContent  = "";
  document.getElementById("emailError").textContent = "";

  let valid = true;
  if (!name) { document.getElementById("nameError").textContent = "Name is required."; valid = false; }
  if (!email || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
    document.getElementById("emailError").textContent = "Valid email is required.";
    valid = false;
  }
  if (!valid) return;

  const output = document.getElementById("formOutput");
  output.style.display = "block";
  output.textContent   = `Thank you, ${name}! You've registered for "${eventType || "an event"}" on ${date || "TBD"}. Confirmation sent to ${email}.`;

  simulateApiPost({ name, email, eventType, date }); // Exercise JS#12
}

function confirmSubmit() {
  console.log("Submit clicked — running validation...");
}

// ============================================================
// JS Exercise 9 + 12: Async/Await + Fetch simulation
// ============================================================
async function simulateApiPost(data) {
  console.log("POSTing registration:", data);
  showSpinner(true);
  try {
    const result = await fakeApiCall(data); // Exercise JS#9: await
    console.log("Server response:", result);
  } catch (err) {
    console.error("Submission error:", err);
  } finally {
    showSpinner(false);
  }
}

function fakeApiCall(data) {
  // Exercise JS#9: Promise; Exercise JS#12: setTimeout delay
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      data.email ? resolve({ status: 200, message: "Saved!" }) : reject(new Error("Invalid"));
    }, 1400);
  });
}

// Exercise JS#9: async/await fetch from mock API
async function fetchEventsFromApi() {
  const container = document.getElementById("eventContainer");
  if (container) container.innerHTML = `<p style="color:var(--text-muted)">Loading events...</p>`;
  try {
    const res  = await fetch("https://jsonplaceholder.typicode.com/posts?_limit=3");
    if (!res.ok) throw new Error("Network error");
    const data = await res.json();
    console.log("Mock API data:", data);
    displayEvents(events); // revert after demo
  } catch (err) {
    console.error("Fetch failed:", err);
    displayEvents(events);
  }
}

function showSpinner(show) {
  const btn = document.getElementById("submitBtn");
  if (!btn) return;
  btn.textContent = show ? "Submitting..." : "Register Now";
  btn.disabled    = show;
}

// ============================================================
// HTML5 Exercise 6: onblur phone validation
// ============================================================
function validatePhone(input) {
  const err = document.getElementById("phoneError");
  const val = input.value.replace(/\D/g, "");
  if (input.value && val.length !== 10) {
    err.textContent           = "Must be 10 digits.";
    input.style.borderColor   = "var(--danger)";
  } else {
    err.textContent           = "";
    input.style.borderColor   = "";
  }
}

// HTML5 Exercise 6: onchange fee display
function showEventFee(select) {
  const fee     = select.options[select.selectedIndex].getAttribute("data-fee") || "";
  const display = document.getElementById("eventFeeDisplay");
  display.textContent = fee ? `Entry fee: ${fee}` : "";
}

// HTML5 Exercise 6: character counter
function countChars(textarea) {
  const max     = 500;
  const current = textarea.value.length;
  const display = document.getElementById("charCount");
  display.textContent = `${current} / ${max} characters`;
  display.style.color = current > max ? "var(--danger)" : "";
}

// HTML5 Exercise 6: feedback dropdown onchange
function showFeedbackCategory(select) {
  const display = document.getElementById("feedbackRatingDisplay");
  display.textContent = select.value ? `You rated: ${select.value}` : "";
}

// HTML5 Exercise 6: onclick feedback submit
function submitFeedback() {
  const text   = document.getElementById("feedbackText").value.trim();
  const rating = document.getElementById("feedbackCategory").value;
  const output = document.getElementById("feedbackOutput");
  if (!text) {
    output.style.display   = "block";
    output.textContent     = "Please write something before submitting.";
    output.style.background = "var(--danger-bg)";
    output.style.color     = "var(--danger)";
    return;
  }
  output.style.display    = "block";
  output.textContent      = `Thank you for your ${rating || "unrated"} feedback! We appreciate your input.`;
  output.style.background = "var(--success-bg)";
  output.style.color      = "var(--success)";
  document.getElementById("feedbackText").value      = "";
  document.getElementById("feedbackCategory").value  = "";
  document.getElementById("charCount").textContent   = "0 / 500 characters";
}

// ============================================================
// HTML5 Exercise 4 + 6: Lightbox (ondblclick image)
// ============================================================
function enlargeImage(img) {
  const lb        = document.getElementById("lightbox");
  const lbImg     = document.getElementById("lightboxImg");
  lbImg.src       = img.src;
  lbImg.alt       = img.alt;
  lb.classList.add("active");
}

function closeLightbox() {
  document.getElementById("lightbox").classList.remove("active");
}

// ============================================================
// HTML5 Exercise 7: video media events
// ============================================================
function videoReady()   { document.getElementById("videoStatus").textContent = "Video is ready to play!"; }
function videoPlaying() { document.getElementById("videoStatus").textContent = "Now playing..."; }
function videoPaused()  { document.getElementById("videoStatus").textContent = "Video paused."; }

// HTML5 Exercise 7: onbeforeunload
function warnBeforeLeave() {
  const name = document.getElementById("fullName");
  if (name && name.value.trim()) return "You have an unfinished registration. Leave anyway?";
}

// ============================================================
// HTML5 Exercise 8: localStorage / sessionStorage
// ============================================================
function savePreference(select) {
  if (select.value) {
    localStorage.setItem("preferredEvent",   select.value);
    sessionStorage.setItem("sessionEvent",   select.value);
    updatePrefDisplay();
    console.log("Preference saved:", select.value);
  }
}

function loadPreferences() {
  const saved = localStorage.getItem("preferredEvent");
  if (saved) {
    const select = document.getElementById("eventType");
    if (select) { select.value = saved; showEventFee(select); }
    console.log("Restored preference:", saved);
  }
}

function updatePrefDisplay() {
  const pref    = localStorage.getItem("preferredEvent");
  const display = document.getElementById("prefDisplay");
  if (display) {
    display.textContent = pref
      ? `Saved: "${pref}" (from localStorage)`
      : "None yet.";
  }
}

function clearPreferences() {
  localStorage.clear();
  sessionStorage.clear();
  const select = document.getElementById("eventType");
  if (select) select.value = "";
  document.getElementById("eventFeeDisplay").textContent = "";
  updatePrefDisplay();
  alert("Preferences cleared!");
}

// ============================================================
// HTML5 Exercise 9: Geolocation
// ============================================================
function findNearbyEvents() {
  const output = document.getElementById("geoOutput");
  output.textContent = "Detecting your location...";

  if (!navigator.geolocation) {
    output.textContent = "Geolocation not supported by your browser.";
    return;
  }

  navigator.geolocation.getCurrentPosition(
    pos => {
      const lat = pos.coords.latitude.toFixed(4);
      const lon = pos.coords.longitude.toFixed(4);
      output.textContent = `Found you: Lat ${lat}, Lon ${lon}. Showing nearest events...`;
      console.log(`Coords: lat=${lat}, lon=${lon}`);
    },
    err => {
      const msgs = {
        [err.PERMISSION_DENIED]:   "Location access denied. Enable location in browser settings.",
        [err.POSITION_UNAVAILABLE]:"Location information unavailable.",
        [err.TIMEOUT]:             "Location request timed out."
      };
      output.textContent = msgs[err.code] || "Unknown error.";
    },
    { enableHighAccuracy: true, timeout: 8000, maximumAge: 0 }
  );
}

// ============================================================
// JS Exercise 10: ES6+ — Destructuring, spread, default params
// ============================================================
function printEventDetails({ name, date, category, fee = "Free" }) {
  console.log(`Event: ${name} | ${date} | ${category} | Fee: ${fee}`);
}

function greetUser(name = "Guest", role = "Visitor") {
  return `Welcome, ${name}! Role: ${role}`;
}

function getFilteredCopy(category) {
  return [...events].filter(e => e.category === category);
}

console.log(greetUser("Priya", "Resident"));
printEventDetails(events[0]);
console.log("Music events:", getFilteredCopy("music").map(e => e.name));

// ============================================================
// JS Exercise 14: jQuery-style via vanilla JS
// ============================================================
document.addEventListener("DOMContentLoaded", () => {
  // jQuery: $('#submitBtn').click(...)
  const btn = document.getElementById("submitBtn");
  if (btn) {
    btn.addEventListener("click", () => {
      console.log("Register button clicked (jQuery-equivalent listener).");
    });
  }

  // Smooth scroll for all anchor nav links
  document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener("click", function(e) {
      e.preventDefault();
      const target = document.querySelector(this.getAttribute("href"));
      if (target) target.scrollIntoView({ behavior: "smooth" });
      document.querySelector(".nav-links").classList.remove("open");
    });
  });
});

// ============================================================
// Navigation mobile toggle (CSS3 Exercise 10 responsive)
// ============================================================
function toggleNav() {
  document.querySelector(".nav-links").classList.toggle("open");
}

// HTML5 Exercise 10: DevTools — debug logs
console.log(`%c[CivicHub] Loaded at ${new Date().toLocaleTimeString()}`, "color:#2563eb;font-weight:bold");
console.log("All events:", events);
console.log("Tip: addEvent(name, date, category, location, seats, fee) to add events from the console.");
