# WorldConnect

A Java app that uses a simple world map and color-coded pins to help users know when it is a good time to call friends and family in different time zones.

## The Problem

Many of my friends and family live in different countries, so it can be hard to know when it is a good time to call them. I usually have to check different time zones manually before reaching out. I wanted to make something that puts all of that information in one place.

## How It Works

- The user can add a person with their name, location, and time zone.
- The program calculates that person's current local time.
- Each person appears as a pin on a simple world map.
- A green pin means it is a good time to call.
- A red pin means it is probably not a good time to call.
- The user can select a pin to see the person's name, location, and local time.
- Saved people can be loaded again later.

![System diagram]\(systems diagram.png)

## Tech Stack

- **Language:** Java
- **Libraries:** `java.time`
- **External tools:** Git, GitHub, and Java `HttpClient` if I use a public time zone or location API
- **Data storage:** CSV or text file using Java File I/O

## Setup

```bash
git clone https://github.com/Shreshthabasu7/WorldConnect
cd WorldConnect
```

The project is still in the planning stage, so more setup instructions will be added once the MVP is built.

## Usage

Once the project is built, the program will allow the user to view saved friends and family on a simple world map. The user will be able to select a person and see their local time and whether it is a good time to call.

```bash
# Run instructions will be added once the Java program is built.
```

## Roadmap

- [ ] Find a good time for a group call
- [ ] Add birthdays and important dates
- [ ] Add reminders for when someone becomes available
- [ ] Add more detailed availability settings

## Author

Shreshtha Basu
[https://github.com/Shreshthabasu7](https://github.com/Shreshthabasu7)

