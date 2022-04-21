<#ftl encoding='UTF-8'>

<#macro registrationTemplate>
    <head>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <form  method="post" action="/reg">
            <div class="form">
                <h1>Регистрация</h1>
                <div class="input-form">
                    <input name="email" type="text" autocomplete="off" minlength="8" maxlength="64" placeholder="Email" required/>
                </div>
                <div class="input-form">
                    <input name="password" type="password" autocomplete="off" minlength="8" maxlength="64" placeholder="Пароль" required>
                </div>
                <div class="input-form">
                    <input name="name" type="text" autocomplete="off" minlength="2" maxlength="30" pattern="^[А-Я].*" placeholder="Имя" required>
                </div>
                <div class="input-form">
                    <input name="surname" type="text" autocomplete="off" minlength="2" maxlength="30" pattern="^[А-Я].*" placeholder="Фамилия" required>
                </div>
                <div class="input-form">
                    <input name ="dateOfBirth" type="text" autocomplete="off" minlength="10" maxlength="10" pattern="^(?:0[1-9]|[12]\d|3[01])([\/.-])(?:0[1-9]|1[012])\1(?:19|20)\d\d$" placeholder="Дата рождения" required>
                </div>
                <div class = "radio">
                    <p><input type="radio" name="role" id="passenger" value="PASSENGER">Вы пассажир</p>
                </div>
                <div class = "radio">
                    <p><input type="radio" name="role" id="driver" value="DRIVER">Вы водитель</p>
                </div>
                <div class="input-form-button">
                    <input type="submit" value="Зарегестрироваться">
                </div>
            </div>
        </form>
        <style>
            body{
                background-image: url(https://i.pinimg.com/originals/71/5c/4e/715c4e2bfc9db0f490736d9d70aad3a1.gif);
                background-attachment: fixed;
                background-position: right;
                background-repeat: no-repeat;
                background-size: 100%;
                margin-top: 10px;
            }
            .form{
                position: absolute;
                top: 50%;
                left: 15%;
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
            .radio{
                font-size: 20px;
                color: white;
            }
            .input-form input{
                padding: 10px;
                width: 100%;
                color: #000000;
                font-size: 20px;
                background: none;
                outline: none;
                border: 1px solid #fff;
                box-sizing: border-box;
                border-radius: 10px;
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
    </head>
</#macro>