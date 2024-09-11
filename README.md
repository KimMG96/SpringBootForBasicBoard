# SpringBootForBasicBoard

<h2>데이터 유효성 관리</h2>
<hr>
 1) 클라이언트에게서 @RequestParam, @RequestBody, @PathVarivable 어노테이션을 통해 api로 호출
 2) api에서는 @Valid, @Validated로 유효성 검증
 3) 유효성 검증 통과시, 성공 응답 Response반환 실패시, MethodArgumentNotValidException 에러 발생
<br>

 <h3>Spring Validation</h3>
 <hr>
 - 클라이언트에서 어노테이션을 통해 서버로 값을 전달시, 해당하는 데이터에 유효성 검증을 수행하여,
  유효하지 않을 경우 에러를 발생하도록 처리하는 라이브러리
 <br<

  <h4>@RequestBody</h4>
  <hr>
