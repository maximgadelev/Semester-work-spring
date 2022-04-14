<#ftl encoding='UTF-8'>
<#macro htmlTemplate pageName>
    <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>${pageName}</title>
    </head>

    <body>
    <#nested>
    </body>
    </html>
</#macro>