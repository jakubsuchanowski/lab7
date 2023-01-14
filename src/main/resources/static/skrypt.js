document.addEventListener('DOMContentLoaded', () => {
    getAllStudents();
});
function getAllStudents(){
    fetch("http://localhost:8080/students")
        .then((response) => {
            if (response.status !== 200) {
                return Promise.reject('Coś poszło nie tak!'); }
            return response.json();
        })
        .then( (data) => { pokazTabele(data); } )
        .catch( (error) => { console.log(error); } );
}
function pokazTabele(response){
    console.log(response);
    var main = document.getElementById('main');
    var content="<table border='1'> <thead><tr><th>ID</th><th> Imię</th>"+
        "<th>Nazwisko</th><th>Średnia</th></tr></thead><tbody>";
    for (var st in response) {
        var id = response[st].id;
        var name = response[st].name;
        var surname = response[st].surname;
        var average = response[st].average;
        content += "<tr><td>" +id+ "</td><td>" + name + "</td><td>" + surname +
            "</td><td>" + average + "</td></tr>";
    }
    content += "</tbody></table>";
    main.innerHTML = content;
}
function addStudent()
{
    const form = document.getElementById('student-form');
    var student = {};
    student.id = form.elements.id.value;
    student.name = form.elements.name.value;
    student.surname = form.elements.surname.value;;
    student.average = form.elements.average.value;
    fetch("http://localhost:8080/students/add", {
        method: 'POST',
        body: JSON.stringify(student),
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then((response) => {
            response.text().then(body => komunikat(body));

        })
        .then(getAllStudents)

}
function deleteStudent(){
    const form = document.getElementById('student-form');
    var id = form.elements.id.value;
    fetch("http://localhost:8080/delete/" + id, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then((response) => {

            response.text().then(body => komunikat(body));

        })
        .then(getAllStudents)
}

function modifyStudent(){
    const form = document.getElementById('student-form');
    var student ={};
    student.id = form.elements.id.value;
    student.name = form.elements.name.value;
    student.surname = form.elements.surname.value;
    student.average = form.elements.average.value;
    fetch("http://localhost:8080/students/edit" , {
        method: 'PUT',
        body: JSON.stringify(student),
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then((response) => {

            response.text().then(body => komunikat(body));

        })
        .then(getAllStudents)
}

function komunikat(body){
    var komunikat = document.getElementById('komunikat');
    content = "<h2>" + body + "</h2>"
    komunikat.innerHTML = content
}