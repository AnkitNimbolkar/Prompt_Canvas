 # Prompt Canvas 🎨🤖

A full-stack AI-powered image generator built with **React (frontend)** and **Spring Boot (backend)**.  
It integrates with the **OpenAI Image Generation API** to create custom images from text prompts.

---

## 🚀 Features
- Generate AI-powered images from text prompts
- Modern, responsive frontend with TailwindCSS
- REST API backend built with Spring Boot
- Clean architecture with service/controller separation

---

## 🛠️ Tech Stack
- **Frontend:** React, TailwindCSS
- **Backend:** Spring Boot (Java), REST APIs
- **AI API:** OpenAI Images API

---

## 📂 Project Structure
```
AI-Photo-Generator/
├── backend/                # Spring Boot app
│   ├── src/main/java/      # Java source code
│   └── src/main/resources/ # Properties & configs
├── frontend/               # React app
│   ├── public/
│   └── src/
└── README.md
```

---

## ⚙️ Setup & Run

### 1️⃣ Backend (Spring Boot)
1. Navigate to the backend:
   ```bash
   cd backend
   ```
2. Set environment variable for your API key:
   ```bash
   export OPENAI_API_KEY=your_api_key_here
   ```
   (On Windows PowerShell, use `$env:OPENAI_API_KEY="your_api_key_here"`)

3. Run the backend:
   ```bash
   ./mvnw spring-boot:run
   ```
   Backend will run on **http://localhost:8082**

---

### 2️⃣ Frontend (React)
1. Navigate to the frontend:
   ```bash
   cd frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the dev server:
   ```bash
   npm start
   ```
   Frontend will run on **http://localhost:3000**

---

## 🔑 Application Properties
All `application.properties` files are **ignored** in Git for security.  
👉 Add your `OPENAI_API_KEY` inside environment variables or a local properties file when running the backend.

---

## 📸 Demo (Coming Soon)
Screenshots / GIFs will be added here once the UI is finalized.

---

## 🤝 Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss.

---

## 📜 License
This project is licensed under the MIT License.
