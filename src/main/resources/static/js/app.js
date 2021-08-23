function say(){
    alert("Hello my Friend!");

}
const btn = document.querySelector(".btn");

btn.addEventListener("click",evt => {
    say();
});
