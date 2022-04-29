<#ftl encoding='UTF-8'>
<head>
    <#macro loggedDriver>
        <nav>
            <ul>
                <li><a href="/main">Главная</a></li>
                <li><a href="/profile">Профиль</a></li>
                <li><a href="/driverActiveTrips">Ваши текущие поездки</a></li>
                <li><a href="/driverEndTrips">Ваши завершенные поездки</a></li>
                <li><a href="/driversFeedback">Отзывы о вас</a></li>
                <li><a href="/logout">Выйти</a></li>
            </ul>
        </nav>
        <style>
            nav{
                width: 100%;
            }
            nav:before{
                content: '';
                display: block;
                height: 50px;
                width: 100%;
                background: rgb(81,186,215);
                position: absolute;
                left: 0;
                z-index: -1;
            }
            ul{
                margin: -10px;
                padding: -10px;
                list-style: none;
                height: 50px;
            }
            ul li{
                float: left;
            }
            ul li a{
                color: #fff;
                display: block;
                height: 50px;
                padding: 0 30px;
                text-transform: uppercase;
                text-decoration: none;
                line-height: 50px;
            }
            ul li a:hover{
                background:  #ffdb06;
            }
        </style>
    </#macro>
</head>
<#macro unloggedUser>
    <nav>
        <ul>
            <li><a href="/login">Логин</a></li>
            <li><a href=/reg>Регистрация</a></li>
            <li><a href="/main">Главная</a> </li>
        </ul>
    </nav>
    <style>
        nav{
            width:100%;
        }
        nav:before{
            content: '';
            display: block;
            height: 50px;
            width: 100%;
            background: rgb(81,186,215);
            position: absolute;
            left: 0;
            z-index: -1;
        }
        ul{
            margin: -10px;
            padding: -10px;
            list-style: none;
            height: 50px;
        }
        ul li{
            float: left;
        }
        ul li a{
            color: #fff;
            display: block;
            height: 50px;
            padding: 0 30px;
            text-transform: uppercase;
            text-decoration: none;
            line-height: 50px;
        }
        ul li a:hover{
            background:  #ffdb06;
        }
    </style>
</#macro>
<head>
    <#macro loggedUser>
        <nav>
            <ul>
                <li><a href="/main">Главная</a></li>
                <li><a href="/profile">Профиль Пассажира</a></li>
                <li><a href ="/activePassengerTrips">Ваши текущие поездки</a></li>
                <li><a href="/endPassengerTrips">Ваши завершенные поездки</a></li>
                <li><a href="/passengersFeedback">Отзывы о вас</a></li>
                <li><a href="/logout">Выйти</a></li>
            </ul>
        </nav>
        <style>
            nav{
                width:100%;
            }
            nav:before{
                content: '';
                display: block;
                height: 50px;
                width: 100%;
                background: rgb(81,186,215);
                position: absolute;
                left: 0;
                z-index: -1;
            }
            ul{
                margin: -10px;
                padding: -10px;
                list-style: none;
                height: 50px;
            }
            ul li{
                float: left;
            }
            ul li a{
                color: #fff;
                display: block;
                height: 50px;
                padding: 0 30px;
                text-transform: uppercase;
                text-decoration: none;
                line-height: 50px;
            }
            ul li a:hover{
                background:  #ffdb06;
            }
        </style>
    </#macro>
</head>
<script>
</script>