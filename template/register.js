function save(){
    const frm = document.querySelector("form");
    const formData = new FormData(frm);
    const jsonData = {};
    formData.forEach((val,key)=>{
        if(jsonData[key]){
            if(typeof jsonData[key] == 'object'){
                jsonData[key].push(val);
            }else{
                jsonData[key]=[jsonData[key],val];
            }
        }else{
            jsonData[key]=val;
        }
        
    });
    fetch("http://127.0.0.1/api/board",{
        method:"POST",
        headers:{
            "Content-Type":"application/text"
        },
        body:JSON.stringify(jsonData)
    }).then(res=>res.text())
    .then(result=>{
        alert("저장되었습니다.");
        location.assign("detail.html?no="+result);
    });
    return false;
}


function getTemplate(){
    fetch(`http://127.0.0.1/api/template/register`)
    .then(res=>res.text())
    .then(result=>{
        document.querySelector("form").innerHTML=result;
    });
}

getTemplate();