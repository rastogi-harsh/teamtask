const BASE_URL = "";


// SIGNUP
async function signup() {

    const data = {

        name: document.getElementById("name").value,

        email: document.getElementById("email").value,

        password: document.getElementById("password").value,

        role: document.getElementById("role").value
    };

    const response = await fetch(
        `${BASE_URL}/api/auth/signup`,
        {
            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(data)
        }
    );

    const result = await response.json();

    alert("Signup Successful");

    console.log(result);
}



// LOGIN
async function login() {

    const data = {

        email: document.getElementById("loginEmail").value,

        password: document.getElementById("loginPassword").value
    };

    const response = await fetch(
        `${BASE_URL}/api/auth/login`,
        {
            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(data)
        }
    );

    const result = await response.text();

    alert(result);

    if(result === "Login Successful") {

        window.location.href = "dashboard.html";
    }
}



// DASHBOARD
async function loadDashboard() {

    const taskResponse =
        await fetch(`${BASE_URL}/api/tasks`);

    const tasks = await taskResponse.json();

    const overdueResponse =
        await fetch(`${BASE_URL}/api/tasks/overdue`);

    const overdueTasks =
        await overdueResponse.json();

    document.getElementById("stats").innerHTML = `

        <h3>Total Tasks: ${tasks.length}</h3>

        <h3>Overdue Tasks: ${overdueTasks.length}</h3>
    `;
}



// CREATE PROJECT
async function createProject() {

    const data = {

        name:
            document.getElementById("projectName").value,

        description:
            document.getElementById("projectDescription").value
    };

    await fetch(`${BASE_URL}/api/projects`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(data)
    });

    alert("Project Created");

    getProjects();
}



// GET PROJECTS
async function getProjects() {

    const response =
        await fetch(`${BASE_URL}/api/projects`);

    const projects = await response.json();

    let html = "";

    projects.forEach(project => {

        html += `
            <div>
                <h3>${project.name}</h3>
                <p>${project.description}</p>
            </div>
        `;
    });

    document.getElementById("projectList")
        .innerHTML = html;
}



// CREATE TASK
async function createTask() {

    const data = {

        title:
            document.getElementById("taskTitle").value,

        description:
            document.getElementById("taskDescription").value,

        status: "PENDING",

        dueDate:
            document.getElementById("dueDate").value,

        project: {
            id: 1
        },

        user: {
            id: 1
        }
    };

    await fetch(`${BASE_URL}/api/tasks`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(data)
    });

    alert("Task Created");

    getTasks();
}



// GET TASKS
async function getTasks() {

    const response =
        await fetch(`${BASE_URL}/api/tasks`);

    const tasks = await response.json();

    let html = "";

    tasks.forEach(task => {

        html += `
            <div>
                <h3>${task.title}</h3>

                <p>${task.description}</p>

                <p>Status: ${task.status}</p>

                <p>Due: ${task.dueDate}</p>
            </div>
        `;
    });

    document.getElementById("taskList")
        .innerHTML = html;
}