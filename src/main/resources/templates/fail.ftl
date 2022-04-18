<#import "navigation.ftl" as navigation>
<#import "common.ftl" as common>
<@common.htmlTemplate pageName="FailPage">
    <@navigation.unloggedUser/>
    <br>
    <h1>Ошибка авторизации</h1>
    <br>
    <div class="alert alert-danger" role="alert">
        Неверный логин или пароль!
    </div>
</@common.htmlTemplate>