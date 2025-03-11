# JOI - Task & Deadline Manager

JOI is a **command-line tool** that helps you manage your tasks and deadlines efficiently. Designed to be **simple and intuitive**, JOI allows you to focus on what’s important without unnecessary complexity.

## 🚀 Features
- **Task Management**: Add, delete, and list tasks with ease.
- **Deadline Tracker**: Keep track of deadlines using intuitive commands.
- **Event Scheduling**: Plan events with start and end dates.
- **Task Status Management**: Mark tasks as completed or incomplete.
- **Task Searching**: Quickly find tasks by keywords.
- **Persistent Storage**: Saves your tasks so they remain available even after restarting.

## 🛠 Installation

1. Clone this repository:
   ```sh
   git clone https://github.com/keanneeee/ip.git
   ```
2. Navigate into the project directory:
   ```sh
   cd joi
   ```
3. Compile the Java files:
   ```sh
   javac -d bin -sourcepath src src/chatbbg/chatBBG.java
   ```
4. Run JOI:
   ```sh
   java -cp bin chatbbg.chatBBG
   ```

## 📖 Usage
JOI operates through simple **command-line inputs**:

```sh
list                 # Displays all tasks

todo <task name>     # Adds a new to-do task

deadline <task> /by <date>  # Adds a deadline task

event <task> /from <start> /to <end>  # Adds an event task

mark <task number>   # Marks a task as completed

unmark <task number> # Marks a task as incomplete

delete <task number> # Deletes a task

find <keyword>       # Finds tasks containing the keyword

goodbye              # Exits JOI and saves tasks
```

## 🏗 Project Structure
```sh
📁 joi
├── 📁 src
│   ├── chatbbg/
│   │   ├── chatBBG.java  # Main chatbot logic
│   │   ├── Extractor.java # Extracts user input details
│   │   ├── Functions.java # Handles user commands
│   │   ├── Storage.java  # Manages file storage
│   │   ├── tasktypes/
│   │   │   ├── Task.java
│   │   │   ├── Todo.java
│   │   │   ├── Deadline.java
│   │   │   ├── Event.java
└── 📁 data (Created at runtime to store tasks)
```

## 🎯 Future Enhancements
- Implement **natural language processing** for more flexible commands.
- Add **GUI support** for an intuitive user interface.
- Support **task priorities** and **reminders**.

## 🤝 Contributing
We welcome contributions! Feel free to submit issues or pull requests.

---
💡 **"I'm JOI. You look lonely, I can fix that."** 💡
```

