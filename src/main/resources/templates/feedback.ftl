<#ftl encoding='UTF-8'>
<#import "common.ftl" as common>
<#import "navigation.ftl" as navigation>

<@common.htmlTemplate pageName="PassengersFeedback">
    <head>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <@navigation.loggedUser/>
    </head>
    <body>
    <div class="container">
        <#if passengersFeedback??>
            <#if passengersFeedback?has_content>
                <#list passengersFeedback as p>
                    <div class="comment">
                                <#list drivers as d>
                                    <#if p.from_passenger_id=d.id>
                                        <div class="comment-author-ava"><img src="${d.profileImage}" alt="Avatar"></div>
                                        <div class="comment-body">
                                            <p class="comment-text">${p.text}</p>
                                            <div class="comment-footer"><span class="comment-meta"><strong>${d.name} ${d.surname}</strong> ${p.added_rating}</span></div>
                                        </div>
                                        </#if>
                                </#list>
                            </div>
                </#list>
            <#else>
                У вас пока нет отзывов:(
            </#if>
        </#if>

    </div>
    </body>
</@common.htmlTemplate>
<style>
    body{
        background-color: whitesmoke;
        margin-top: 10px;
    }
    .container{
        padding-top: 80px;
    }
    .comment {
        display: block;
        position: relative;
        padding-bottom: 20px;
        padding-left: 10px;
    }
    .comment .comment-author-ava {
        display: block;
        position: absolute;
        top: 0;
        left: -45px;
        width: 50px;
        border-radius: 50%;
        overflow: hidden
    }
    .comment .comment-author-ava>img {
        display: block;
        width: 50px;
        height: 50px;
    }
    .comment .comment-body {
        position: relative;
        padding: 24px;
        border: 1px solid #e1e7ec;
        border-radius: 7px;
        background-color: #fff
    }
    .comment .comment-body::after,
    .comment .comment-body::before {
        position: absolute;
        top: 12px;
        right: 100%;
        width: 0;
        height: 0;
        border: solid transparent;
        content: '';
        pointer-events: none
    }
    .comment .comment-body::after {
        border-width: 9px;
        border-color: transparent;
        border-right-color: #fff
    }
    .comment .comment-body::before {
        margin-top: -1px;
        border-width: 10px;
        border-color: transparent;
        border-right-color: #e1e7ec
    }
    .comment .comment-text {
        margin-bottom: 12px
    }
    .comment .comment-footer {
        display: table;
    }
    .comment .comment-meta {
        color: #9da9b9;
        font-size: 13px
    }
</style>