<#ftl encoding='UTF-8'>
<#import "common.ftl" as common>
<#import "navigation.ftl" as navigation>

<@common.htmlTemplate pageName="Driver">
    <head>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <title>Driver</title>
        <@navigation.loggedDriver/>
    </head>
    <body>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-9">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">Профиль пользователя</h4>
                    </div>
                    <div class="panel-body">
                        <div class="profile__avatar">
                            <img src="${passenger.profileImage}" alt="...">
                        </div>
                        <div class="profile__header">
                            <h3>${passenger.name} ${passenger.surname} <small>Водитель</small></h3>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-body">
                        <table class="table profile__table">
                            <tbody>
                            <tr>
                                <th><strong>Имя</strong></th>
                                <td>${passenger.name}</td>
                            </tr>
                            <tr>
                                <th><strong>Фамилия</strong></th>
                                <td>${passenger.surname}</td>
                            </tr>
                            <tr>
                                <th><strong>Логин</strong></th>
                                <td>${passenger.email}</td>
                            </tr>
                            <tr>
                                <th><strong>Рейтинг</strong></th>
                                <td>${passenger.rating}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- Community -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">Ваша Машина</h4>
                    </div>
                    <#if car?has_content>
                        <div class="panel-body">
                            <table class="table profile__table">
                                <tbody>
                                <tr>
                                    <th><strong>Номер</strong></th>
                                    <td>${car.number}</td>
                                </tr>
                                <tr>
                                    <th><strong>Бренд</strong></th>
                                    <td>${car.brand}</td>
                                </tr>
                                <tr>
                                    <th><strong>Модель</strong></th>
                                    <td>${car.model}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                    <#else>
                        <tbody>
                        <th><strong>У вас пока нет машины:( </strong></th>
                        <form action="/addCar">
                            <button type="submit">
                                Добавить машину
                            </button>
                        </form>
                        </tbody>
                    </#if>
                </div>
            </div>
        </div>
        <div class="button">
            <form action="/upload" method="post" enctype="multipart/form-data">
                <input type="file" name="file"> <input type="submit" value="Сменить фото">
            </form>
        </div>
    </div>
    </body>
    <style>
        .container{
            margin-right: 500px;
        }
        body{
            background: #f5f5f5;
            margin-top: 10px;
        }
        .panel {
            box-shadow: none;
        }
        .panel-heading {
            border-bottom: 0;
        }
        .panel-title {
            font-size: 20px;
        }
        .panel-title > small {
            font-size: .75em;
            color: #999999;
        }
        .panel-body *:first-child {
            margin-top: 0;
        }
        .panel-default > .panel-heading {
            color: #333333;
            margin-top: 30px;
            background-color: transparent;
            border-color: rgb(65, 234, 245);
        }
        .profile__avatar {
            float: left;
            margin-bottom: 40px;
            width: 60px;
            height: 60px;
            border-radius: 50%;
            overflow: hidden;
        }
        @media{
            .profile__avatar {
                width: 150px;
                height: 150px;
            }
        }
        .profile__avatar > img {
            width: 100%;
            height: 100%;
        }
        .profile__header {
            overflow: hidden;
        }
        .profile__header p {
            margin: 20px 0;
        }
        @media (min-width: 992px) {
            .profile__table tbody th {
                width: 200px;
            }
        }
        @media (max-width: 767px) {
            .profile-comments__sender > small {
                display: block;
                margin: 5px 0 10px;
            }
        }
    </style>
</@common.htmlTemplate>

</html>