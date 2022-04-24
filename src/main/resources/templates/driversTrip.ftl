<#ftl encoding='UTF-8'>
<#import "common.ftl" as common>
<#import "navigation.ftl" as navigation>
<@common.htmlTemplate pageName="driversTrip">
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <@navigation.loggedUser/>
    <#if tripDriver?has_content>
        <#if driverCar?has_content>
            <div class="bg-white card mb-4 order-list shadow-sm">
                <div class="gold-members p-4">
                    <div class="media">
                        <img class="mr-4" src="${tripDriver.profileImage}" alt="Generic placeholder image">
                        <div class="media-body">
                            <h6 class="mb-2">
                                <div class="text-black">${tripDriver.name} ${tripDriver.surname}</div>
                            </h6>
                            <p class="text-gray mb-1"><i class="icofont-location-arrow"></i> Машина:${driverCar.brand} ${driverCar.model}
                            </p>
                            <p class="text-gray mb-3"><i class="icofont-list"></i> Номер:${driverCar.number} <i class="icofont-clock-time ml-2"></i></p>
                            <div class="float-right">
                                <form action="/addFeedbackForDriver" method="get">
                                    <input type="hidden" name="driverId" value='${tripDriver.id}'>
                                    <input type="submit" value="Написать отзыв" class="btn btn-sm btn-primary">
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </#if>
    </#if>
    <style>
        body{
            background:#eee;
            margin-top: 10px;
        }
        .order-list .btn {
            border-radius: 2px;
            min-width: 121px;
            font-size: 13px;
            padding: 7px 0 7px 0;
        }
        .sahan-user-media img {
            width: 90px;
        }
        .card.offer-card h5 {
            border: 1px dotted #daceb7;
            display: inline-table;
            color: #17a2b8;
            margin: 0 0 19px 0;
            font-size: 15px;
            padding: 6px 10px 6px 6px;
            border-radius: 2px;
            background: #fffae6;
            position: relative;
        }
        .card.offer-card h5 img {
            height: 22px;
            object-fit: cover;
            width: 22px;
            margin: 0 8px 0 0;
            border-radius: 2px;
        }
        .payments-item .media img {
            margin: 0 40px 0 11px !important;
        }
        .order-list img.mr-4 {
            width: 70px;
            height: 70px;
            object-fit: cover;
            box-shadow: 0 .125rem .25rem rgba(0, 0, 0, .075)!important;
            border-radius: 2px;
        }
        .h1, .h2, .h3, .h4, .h5, .h6, h1, h2, h3, h4, h5, h6 {
            color: #000000;
        }
        .shadow-sm {
            margin-top: 30px;
            width: 800px;
            height: 210px;
        }
        a:hover{
            text-decoration:none;
        }
    </style>
</@common.htmlTemplate>