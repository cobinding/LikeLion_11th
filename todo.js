
// 괄호 안에는 가져올 html의 id를 parameter로 넘겨준다.
const addToDoButton = document.getElementById('addToDoBtn');
const toDoContainer = document.getElementById('toDoContainer');
const inputField = document.getElementById('inputField');

// click event가 발생했을 때 func 실행
addToDoButton.addEventListener('click', function() {
    // paragraph 변수에 p tag 요소 생성 (입력될 애들..)
    const paragraph = document.createElement('p');

    // p 태그에 클래스명이 없으니 클래스명을 설정해주자.
    // 이렇게 하면 css 코드 적용 가능해진다! -> 클래스명을 설정한 거니까.
    paragraph.classList.add('paragraph-styling');

    // p 태그에 들어갈 text를 생성해주는 것. innerText == 내부 글자.
    // inputField : html input의 id를 위 const를 통해 변수로 선언함.
    paragraph.innerText = inputField.value;

    //js에서 만든 class를 html에 append해줘야함
    toDoContainer.appendChild(paragraph);

    
    // 입력창 내용 입력 후 없애는 것

    // input field 초기화
    inputField.value="";

    // ---------------------------------- //
    // 마우스 클릭으로 저장된 내용 제어
    paragraph.addEventListener('click', function() {
        paragraph.style.textDecoration = "line-through";

    })

    paragraph.addEventListener('dblclick', function() {
        toDoContainer.removeChild(paragraph);
    })



}) 
