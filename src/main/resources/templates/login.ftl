<#ftl encoding='UTF-8'>
<#macro loginTemplate>
    <head>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <#if err?has_content>
        <h1>Неправильный логин или пароль!</h1>
    </#if>
    <form action="/login" method ="post">
        <div class="form">
            <h1>Вход</h1>
            <div class="input-form">
                <input name="email" type="text" maxlength="40" required placeholder="Email"/>
                <br>
            </div>
            <div class="input-form">
                <input name="password" type="password" maxlength="30" required placeholder="Пароль">
                <br>
            </div>
            <div class="input-form-button">
                <input type="submit" value="Войти">
            </div>
            <input type="checkbox" name="remember" value="Запомнить меня">
        </div>
    </form>

    <style>
        body{
            background: url("https://i.pinimg.com/originals/9c/05/37/9c0537248b1ec21f81499e967f25ada8.png");
            background-attachment: fixed;
            background-repeat: repeat-x;
            background-size: 100%
        }
        .form{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            border-radius: 10px;
            background: rgb(81,186,215);
        }
        .form h1{
            margin: 30px 100px;
            padding: 0;
            text-align: center;
            color: #fff;
            font-size: 30px;
            text-transform: uppercase;
        }
        .input-form{
            border-radius: 10px;
            background: white;
            margin: 15px 40px;
            text-align: center;
        }
        .input-form input{
            padding: 10px;
            width: 100%;
            color: #000000;
            font-size: 20px;
            background: none;
            outline: none;
            border: 1px solid #ffffff;
            box-sizing: border-box;
            border-radius: 10px;
        }
        .input-form input[type="submit"]{
            margin-top: 20px;
            color: black;
            font-weight: bold;
            text-transform: uppercase;
            border: none;
            background: rgb(255, 255, 255);
            transition: .3s;
        }
        .input-form-button input{
            padding: 10px;
            width: 100%;
            color: #fff;
            font-size: 20px;
            background: none;
            outline: none;
            border: 1px solid #fff;
            box-sizing: border-box;
            border-radius: 10px;
        }
        .input-form-button{
            border-radius: 10px;
            margin: 15px 40px;
            text-align: center;
            cursor: pointer;
        }
        .input-form-button input[type="submit"]{
            margin-top: 20px;
            color: black;
            font-weight: bold;
            text-transform: uppercase;
            border: none;
            background: rgb(255, 255, 255);
            transition: .3s;
        }
        .input-form-button input[type="submit"]:hover{
            background: skyblue;
        }
    </style>
    <script>
    </script>
</#macro>