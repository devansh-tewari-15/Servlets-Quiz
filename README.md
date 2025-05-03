# 📚 Quiz Webapp

A dynamic web-based quiz application built using **Java Servlets** and **HTML**, designed to test users on Servlet-related concepts. The application is session-aware, tracks user progress, evaluates answers, and presents a final result.

---

## 🚀 How it Works

1. **User Enters Name**: The quiz starts by asking the user to input their name.
2. **Session Tracking**: Each user’s name and answers are tracked using `HttpSession`.
3. **Question Navigation**: Questions are presented one at a time with two options each.
4. **Form Submission**: On submitting an answer, the response is recorded and the next question is displayed.
5. **Final Score**: After all 10 questions, the score is calculated and a custom message is shown based on performance.

---

## 💡 Concepts Used

- **Servlet Basics**: Understanding `HttpServlet`, `doGet()` and `doPost()` methods.
- **Session Management**: Using `HttpSession` to persist data across multiple requests.
- **Form Handling**: Handling form submissions via POST method and validating inputs.
- **Dynamic HTML with Servlets**: Generating HTML content using `PrintWriter`.
- **Conditional Logic**: Checking correct answers and calculating score.
- **Static and Dynamic Resources**: Linking external stylesheets and favicon.
- **Client Redirection**: Navigating between HTML and servlet-based pages.
- **Radio Button Validation**: Ensuring user selects one answer using `required` attribute.
- **Custom CSS Styling**: Clean UI using CSS to style quiz page and result screen.

---

## 🛠 Technologies

- Java EE (Servlets & JSP)
- HTML5 & CSS3
- Apache Tomcat
- Eclipse IDE

## 💡 Features

- Interactive quiz of 10 questions related to Java Servlets
- Tracks user score using sessions
- Displays dynamic result based on score
- Styled UI with external CSS
- Uses `POST` for form submission and session tracking for state maintenance

---

## 📁 Project Structure

```
Quiz-WebApp/
├── WebContent/
│   ├── quizApp.html          # Landing page where users enter their name and start the quiz
│   ├── styles.css            # Styling for all HTML pages
│   └── WEB-INF/
│       └── web.xml           # Web deployment descriptor (optional if annotations are used)
│
├── src/
│   └── com.quizServlet/
│       ├── startQuizServlet.java     # Handles initial name input and quiz session start
│       ├── questionServlet.java      # Displays each quiz question and handles user answers
│       └── resultQuizServlet.java    # Calculates score and displays final result
│
├── README.md                # Project documentation
```
---

## ▶️ How to Run

### Requirements

- Java JDK 8 or later
- Apache Tomcat 9 or later
- Eclipse IDE (or any IDE with servlet support)
- Git

### Steps

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/Quiz-WebApp.git
   ```

2. **Import into Eclipse:**
   - Open Eclipse.
   - Go to `File` > `Import` > `Existing Projects into Workspace`.
   - Select the `Quiz-WebApp` folder.
   - Click **Finish**.

3. **Run on Server:**
   - Right-click the project > `Run As` > `Run on Server`.
   - Choose **Tomcat** and click **Finish**.

4. **Access the Application:**
   ```
   http://localhost:8080/Quiz-WebApp/quizApp.html
   ```
---
## 🛠️ Author
Devansh Tewari  
📧 tewari.devansh15@gmail.com  
📌 Java Servlets| Web App 

---

## 📃 License
This project is open-source and free to use for educational or personal purposes.
