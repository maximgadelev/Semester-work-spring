<#ftl encoding='UTF-8'>
<#import "common.ftl" as common>
<#import "navigation.ftl" as navigation>

<@common.htmlTemplate pageName="DriversTripsPassengers">
    <head>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <@navigation.loggedDriver/>
    <#if tripsPassengers??>
        <#if tripsPassengers?has_content>
            <#list tripsPassengers as p>
                <div class="bg-white card mb-4 order-list shadow-sm">
                    <div class="gold-members p-4">
                        <div class="media">
                            <img class="mr-4" src="${p.profileImage}" alt="Generic placeholder image">
                            <div class="media-body">
                                <h6 class="mb-2">
                                    <div class="text-black">${p.name} ${p.surname}</div>
                                </h6>

                                <div class="float-right">
                                    <form action="/addFeedbackForUser" method="get">
                                        <input type="hidden" name="pId" value='${p.id}'>
                                        <input type="submit" value="Написать отзыв" class="btn btn-sm btn-primary">
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </#list>
        </#if>
    <#else>
        <br>
        <h1>В данной поездке нет пассажиров:(</h1>
        <br>
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