<#ftl encoding='UTF-8'>
<head>
    <#macro loggedDriver>
        <nav>
            <ul>
                <li><a href="/main">Главная</a></li>
                <li><a href="/profile">Профиль</a></li>
                <li><a href="/activeDriverTrips">Ваши текущие поездки</a></li>
                <li><a href="/endDriverTrips">Ваши завершенные поездки</a></li>
                <li><a href="/feedback">Отзывы о вас</a></li>
                <li><a id="toggler" href="#">Написать в чат</a></li>
                <li><a href="/logout">Выйти</a></li>
            </ul>
        </nav>

        <div class="card" style="position: absolute">

            <#--сообщения-->
            <div id="box" style="display: none; background: white;">

                <div class="layer">
                    <table id="greetings">
                    </table>
                </div>

                <br>

                <div style="display: flex;">
                    <input type="text" id="message" class="form-control" placeholder="Your message..."
                           style="width: 200px; height: 35px;">

                    <button id="send" class="btn btn-default" onclick="sendMessage($('#message').val())">
                        Send
                    </button>
                </div>


            </div>
        </div>
        <script type="text/javascript">
            window.onload = function () {
                document.getElementById('toggler').onclick = function () {
                    openbox('box', this);
                    return false;
                };
            };

            function openbox(id, toggler) {
                const div = document.getElementById(id);
                if (div.style.display === 'block') {
                    div.style.display = 'none';
                    toggler.innerHTML = 'Написать в чат';
                    disconnect();
                } else {
                    div.style.display = 'block';
                    toggler.innerHTML = 'Написать в чат';
                    connect();
                }
            }
        </script>
        <script type="text/javascript" src="/app.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>


        <style>
            nav {
                width: 100%;
            }

            nav:before {
                content: '';
                display: block;
                height: 50px;
                width: 100%;
                background: rgb(81, 186, 215);
                position: absolute;
                left: 0;
                z-index: -1;
            }

            ul {
                margin: -10px;
                padding: -10px;
                list-style: none;
                height: 50px;
            }

            ul li {
                float: left;
            }

            ul li a {
                color: #fff;
                display: block;
                height: 50px;
                padding: 0 30px;
                text-transform: uppercase;
                text-decoration: none;
                line-height: 50px;
            }

            ul li a:hover {
                background: #ffdb06;
            }

            td {
                max-width: 250px;
                word-break: break-all;
            }

            .layer {
                text-align: left;
                overflow-y: scroll;
                width: 250px;
                height: 300px;
                padding: 5px;
                border: solid 1px black;
            }

            textarea {
                background: gray;
            }

            #box {
                position: fixed;
                right: 10px;
                bottom: 10px;
                padding: 10px;
            }

            textarea::placeholder {
                color: white;
            }

            label,
            textarea {
                font-size: .8rem;
                letter-spacing: 1px;
            }

            textarea {
                padding: 10px;
                max-width: 100%;
                line-height: 1.5;
                border-radius: 5px;
                border: 1px solid #ccc;
                box-shadow: 1px 1px 1px #999;
            }

            label {
                display: block;
                margin-bottom: 10px;
            }

        </style>
    </#macro>
</head>
<#macro unloggedUser>
    <nav>
        <ul>
            <li><a href="/login">Логин</a></li>
            <li><a href=/reg>Регистрация</a></li>
            <li><a href="/main">Главная</a></li>
        </ul>
    </nav>
    <style>
        nav {
            width: 100%;
        }

        nav:before {
            content: '';
            display: block;
            height: 50px;
            width: 100%;
            background: rgb(81, 186, 215);
            position: absolute;
            left: 0;
            z-index: -1;
        }

        ul {
            margin: -10px;
            padding: -10px;
            list-style: none;
            height: 50px;
        }

        ul li {
            float: left;
        }

        ul li a {
            color: #fff;
            display: block;
            height: 50px;
            padding: 0 30px;
            text-transform: uppercase;
            text-decoration: none;
            line-height: 50px;
        }

        ul li a:hover {
            background: #ffdb06;
        }
    </style>
</#macro>
<head>
    <#macro loggedUser>
        <nav>
            <ul>
                <li><a href="/main">Главная</a></li>
                <li><a href="/profile">Профиль Пассажира</a></li>
                <li><a href="/activePassengerTrips">Ваши текущие поездки</a></li>
                <li><a href="/endPassengerTrips">Ваши завершенные поездки</a></li>
                <li><a href="/feedback">Отзывы о вас</a></li>
                <li><a href="/logout">Выйти</a></li>
            </ul>
        </nav>
        <style>
            nav {
                width: 100%;
            }

            nav:before {
                content: '';
                display: block;
                height: 50px;
                width: 100%;
                background: rgb(81, 186, 215);
                position: absolute;
                left: 0;
                z-index: -1;
            }

            ul {
                margin: -10px;
                padding: -10px;
                list-style: none;
                height: 50px;
            }

            ul li {
                float: left;
            }

            ul li a {
                color: #fff;
                display: block;
                height: 50px;
                padding: 0 30px;
                text-transform: uppercase;
                text-decoration: none;
                line-height: 50px;
            }

            ul li a:hover {
                background: #ffdb06;
            }

        </style>
    </#macro>
</head>
