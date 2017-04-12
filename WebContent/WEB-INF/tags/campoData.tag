<%@ attribute name="id" required="true" %>
<input id="${id}" name="${id}" value="${dataNascimento}" required/>
<script>
$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>