<#import "common.ftl" as common>
<#import "login.ftl" as login>
<#import "navigation.ftl" as navigation>

<@common.htmlTemplate pageName="Login">

    <@navigation.unloggedUser/>
    <@login.loginTemplate/>
</@common.htmlTemplate>