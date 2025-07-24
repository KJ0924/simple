function changeTemplate(){
    getTemplate()
}

function getTemplate(){
    const template = document.querySelector("#template").value;
    fetch(`http://127.0.0.1/api/template/${template}`)
    .then(res=>res.text())
    .then(result=>{
        document.querySelector("#editArea").value=result;
        document.querySelector("#editArea").dispatchEvent(new Event("input"));
    });
}

const editArea = document.querySelector("#editArea");
editArea.addEventListener("input",preview);

function preview(event){
    const  previewArea= document.querySelector("#previewArea");
    const editArea = document.querySelector("#editArea");
    previewArea.innerHTML = editArea.value;

}
getTemplate();

function saveTemplate(){
    const template = document.querySelector("#template").value;
    const html = document.querySelector("#editArea").value;
    fetch(`http://127.0.0.1/api/template/${template}`,{
        method:"POST"
        ,body:html
    })
    .then(res=>res.text())
    .then(result=>{
        alert("저장되었습니다.");
    });
}