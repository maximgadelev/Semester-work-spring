<#ftl encoding='UTF-8'>
<#import "common.ftl" as common>
<#import "navigation.ftl" as navigation>

<@common.htmlTemplate pageName="TripsBySearch">
    <head>
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body>
    <#if passenger?has_content>
        <@navigation.loggedUser/>
        <div class="container">
            <#if trips??>
                <#if trips?has_content>
                    <#list trips as t>
                        <div class="bg-white  mb-4 order-list shadow-sm">
                        <div class="gold-members p-4">
                            <div class="media">
                                <div class="media-body">
                                    <span class="float-right text-info">${t.path}<i
                                                class="icofont-check-circled text-success"></i></span>
                                    <h4 class="mb-2">
                                        <div class="text-black">Поездка</div>
                                    </h4>
                                    <p class="text-gray mb-1"><i class="icofont-location-arrow"></i>Дата:${t.date}
                                    </p>
                                    <p class="text-gray mb-3"><i class="icofont-list"></i>Время:${t.time}<i
                                                class="icofont-clock-time ml-2"></i></p>
                                    <hr>
                                    <div class="float-right">
                                        <form action="/getTrip" method="post" class="btn btn-sm btn-primary">
                                            <input type="hidden" name="tripId"
                                                   value='${t.id}'>
                                            <input type="submit" class="btn btn-sm btn-primary" value="Бронировать">
                                        </form>
                                    </div>
                                    <p class="mb-0 text-black text-primary pt-2"><span
                                                class="text-black font-weight-bold">Цена за ${places} места</span>:${(t.price)*places}
                                    </p>
                                </div>
                            </div>
                        </div>
                    </#list>
                </#if>
                </div>
                <#else>
                Таких поездок нет(
            </#if>
        </div>
    <#else>
        <@navigation.unloggedUser/>
        <div class="container">
            <#if trips??>
                <#if trips?has_content>
                    <#list trips as t>
                        <div class="bg-white  mb-4 order-list shadow-sm">
                        <div class="gold-members p-4">
                            <div class="media">
                                <div class="media-body">
                                <span class="float-right text-info">${t.path}<i
                                            class="icofont-check-circled text-success"></i></span>
                                    <h4 class="mb-2">
                                        <div class="text-black">Поездка</div>
                                    </h4>
                                    <p class="text-gray mb-1"><i class="icofont-location-arrow"></i>Дата:${t.date}
                                    </p>
                                    <p class="text-gray mb-3"><i class="icofont-list"></i>Время:${t.time}<i
                                                class="icofont-clock-time ml-2"></i></p>
                                    <hr>
                                    <div class="float-right">
                                        <input type="submit" class="btn btn-sm btn-primary" id="myBtn" type="submit"
                                               value="Бронировать" onclick="onClick()">
                                    </div>
                                    <p class="mb-0 text-black text-primary pt-2"><span
                                                class="text-black font-weight-bold">Цена за ${places} места</span>:${(t.price)*places}
                                    </p>
                                </div>
                            </div>
                        </div>
                    </#list>
                </#if>
                </div>
            </#if>
        </div>
    </#if>
    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="onClick2()">&times;</span>
            <p>Чтобы забронировать поездку,небходимо войти в ваш профиль!</p>
        </div>
    </div>
    </body>




    <script>
        var modal = document.getElementById('myModal');
        var btn = document.getElementById('myBtn');
        var span = document.getElementsByClassName('close')[0];
        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }

        function onClick() {
            modal.style.display = "block"
        }

        function onClick2() {
            modal.style.display = "none";
        }
    </script>

    <style>
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: aliceblue;
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        body {
            background: #eeeeee;
        }

        .order-list .btn {
            border-radius: 20px;
            min-width: 121px;
            font-size: 13px;
            padding: 7px 0 7px 0;
        }

        .osahan-account-page-left .nav-link.active i {
            background: #282c3f !important;
        }

        .h1, .h2, .h3, .h4, .h5, .h6, h1, h2, h3, h4, h5, h6 {
            color: #000000;
        }

        .shadow-sm {
            margin-top: 30px;
            width: 800px;
            height: 210px;
        }

        a:hover {
            text-decoration: none;
        }
    </style>
</@common.htmlTemplate>