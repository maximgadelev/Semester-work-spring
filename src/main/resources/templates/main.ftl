<#ftl encoding='UTF-8'>
<#import "common.ftl" as common>
<#import "navigation.ftl" as navigation>
<head>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<@common.htmlTemplate pageName="Main">
    <#if passenger?has_content>
        <@navigation.loggedUser/>
        <form action="/main" method="post" class="find">
            <input name="first" type="text" placeholder="Откуда" required>
            <input name="second" type="text" placeholder="Куда" required>
            <input name ="date" type="text" placeholder="Дата" required>
            <input  name = "time" type="text" placeholder="Время" required>
            <input name ="places" type="number" placeholder="Количество мест" required>
            <div class = "radio">
                <input type="radio" name="check" id="price" value="price">Сначала самые дешевые
            </div>
            <button type="submit">Найти</button>
        </form>
        <H4>Здесь вы сможете найти оптимальный вариант поездки среди широкого выбора по самой низкой цене!</H4>
    <#else>
        <#if driver?has_content>
            <@navigation.loggedDriver/>
            <H1>Станьте водителем вместе с нами - берите попутчиков и экономьте на бензине!</H1>
            <#if car?has_content>
                <form action="/addTrip" method="get">
                    <button type="submit" class="addCar">Добавить новую поездку</button>
                </form>
            <#else>
                <button type="submit" class="addCar" id="myBtn" type="submit" onclick="onClick()">Добавить новуе поездку</button>
                <div id="myModal" class="modal">
                    <div class="modal-content">
                        <span class="close" onclick="onClick2()">&times;</span>
                        <p>Необходимо добавить машину,чтобы совершать поездки!</p>
                    </div>
                </div>
            </#if>
        <#else>
            <@navigation.unloggedUser/>
            <form action="/main" method="post" class="find">
                <input name="first" type="text" placeholder="Откуда" required>
                <input name="second" type="text" placeholder="Куда" required>
                <input name ="date" type="text" placeholder="Дата" required>
                <input  name = "time" type="text" placeholder="Время" required>
                <input name ="places" type="number" placeholder="Количество мест" required>
                <div class = "radio">
                    <input type="radio" name="check" id="price" value="price">Сначала самые дешевые
                </div>
                <button type="submit">Найти</button>
            </form>
            <H4>Здесь вы сможете найти оптимальный вариант поездки среди широкого выбора по самой низкой цене!</H4>
        </#if>
    </#if>
</@common.htmlTemplate>




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
    body{
        background: url(https://i.pinimg.com/originals/85/9c/37/859c37db7f07c21508649e3c31ff8490.gif);
        background-attachment: fixed;
        position: relative;
        background-position: right;
        background-repeat: no-repeat;
        background-size: 100%;
        margin-top: 10px;
    }
    .find {
        text-align: center;
        width: 400px;
        height: 400px;
        border-radius: 10px;
        background: rgb(81, 186, 215);
        opacity: 0.9;
        margin-top: 1%;
        margin-left: 37%;
    }
    input {
        width: 200px;
        margin: 5px;
        height: 50px;
        padding-left: 10px;
        border: 2px solid #7BA7AB;
        border-radius: 10px;
        outline: none;
        background: white;
        color: #9E9C9C;
    }
    button {
        text-align: center;
        margin-top: 30%;
        width: 300px;
        height: 30px;
        border: none;
        background: rgb(81, 186, 215);
        border-radius: 10px;
        cursor: pointer;
        font-size: 20px;
    }
    input[type=radio]{
        border: 0px;
        width: 100%;
        vertical-align: middle;
        height: 2em;
        margin-left:-33%;
        margin: -2px;
    }
    h4{
        color: black;
        position: absolute;
        font-size: 30px;
        text-align: center;
        margin-top: 105px;
        margin-left: 180px;
        border: black;
    }
    h1{
        top:50%;
        left:40%;
        display: inline;
        position: absolute;
        margin-top: -225px;
        margin-left: -225px;
    }
    button.addCar{
        text-align: center;
        margin-top: 30%;
        margin-left: -40%;
        width: 500px;
        height: 50px;
        border: none;
        background: rgb(81, 186, 215);
        border-radius: 10px;
        cursor: pointer;
        font-size: 20px;
    }
</style>
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