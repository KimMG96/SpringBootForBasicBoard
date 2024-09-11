# SpringBootForBasicBoard

<h2>데이터 유효성 관리</h2>
<hr>
 1) 클라이언트에게서 @RequestParam, @RequestBody, @PathVarivable 어노테이션을 통해 api로 호출<br>
 2) api에서는 @Valid, @Validated로 유효성 검증<br>
 3) 유효성 검증 통과시, 성공 응답 Response반환 실패시, MethodArgumentNotValidException 에러 발생<br>
<br>

 <h3>Spring Validation</h3>
 <hr>
 - 클라이언트에서 어노테이션을 통해 서버로 값을 전달시, 해당하는 데이터에 유효성 검증을 수행하여,<br>
  유효하지 않을 경우 에러를 발생하도록 처리하는 라이브러리<br>
 <br>

  <h4>@RequestBody</h4>
  <hr>
  - 클라이언트에서 서버로 전송되는 JSON 타입의 데이터를 자바 객체의 형태로 값을 매칭시켜 받게하는 어노테이션<br>
  - @Valid와 @RequestBody 함께 사용하여 JSON 데이터를 유효성 검증을 거쳐서 로직을 실행하도록 가능<br>
  <br>

  <h4>@RequestParam</h4>
  <hr>
  - 클라이언트에서 서버로 전송되는 query string 데이터를 받기 위해 사용되는 어노테이션<br>
  <br>

  <h4>@PathVariable</h4>
  <hr>
  - 클라이언트에서 Rest형태로 서버에 전송되는 데이터를 받기 위해 사용되는 어노테이션<br>
  <br><br>
  
  <h4>@Valid와 @Validated</h4>
  <hr>
  - @Validated는 @Valid 기능을 모두 포함하고 있으며, 추가로 유효성 검토를 할 수 있는 그룹을  지정 가
  - @Valid는 Java에서 제공, @Validated는 Spring framework에서 제공
 
