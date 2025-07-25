const no = location.search.split("=")[1];
function getTemplate(){
    fetch(`http://127.0.0.1/api/template/detail`)
    .then(res=>res.text())
    .then(result=>{
        document.querySelector("body").innerHTML = result;
        getData();
    });
}

function getData(){
    fetch(`http://127.0.0.1/api/board/${no}`)
    .then(res=>res.json())
    .then(result => {
        for(const [key, val] of Object.entries(result)){
            if(document.querySelector("#"+key)){
                document.querySelector("#"+key).innerText=val;
            }
        }
    });
}

getTemplate();

function remove(){
    if(confirm("삭제하시겠습니까?")){
        fetch(`http://127.0.0.1/api/board/${no}`,{
        method:"DELETE"
    })
        .then(res=>res.text())
        .then(result=>{
            alert("삭제되었습니다.");
            location.assign("/register.html");
        });    
    }
}
