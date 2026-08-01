const URL = "http://localhost:9090/student";

loadStudents();

async function loadStudents() {
  const response = await fetch(URL);
  const students = await response.json();

  let rows = "";

  students.forEach((student) => {
    rows += `
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>
                <button class="edit"
                    onclick="editStudent(${student.id},'${student.name}',${student.age})">
                    Edit
                </button>

                <button class="delete"
                    onclick="deleteStudent(${student.id})">
                    Delete
                </button>
            </td>
        </tr>
        `;
  });

  document.getElementById("studentTable").innerHTML = rows;
}

async function saveStudent() {
  const id = document.getElementById("studentId").value;

  const student = {
    name: document.getElementById("name").value,
    age: document.getElementById("age").value,
  };

  if (id == "") {
    await fetch(URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(student),
    });
  } else {
    await fetch(URL + "/" + id, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(student),
    });
  }

  clearForm();
  loadStudents();
}

function editStudent(id, name, age) {
  document.getElementById("studentId").value = id;
  document.getElementById("name").value = name;
  document.getElementById("age").value = age;
}

async function deleteStudent(id) {
  await fetch(URL + "/" + id, {
    method: "DELETE",
  });

  loadStudents();
}

function clearForm() {
  document.getElementById("studentId").value = "";
  document.getElementById("name").value = "";
  document.getElementById("age").value = "";
}
