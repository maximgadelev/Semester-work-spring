<#ftl encoding='UTF-8'>
<#import "common.ftl" as common>
<@common.htmlTemplate pageName="addFeedBackForUser">
    <form action="/addFeedbackForUser" method="post">
        <div id="txt1">Cимволов из 100/<span>0</span></div>
        <textarea class="form-control" maxlength="100" name="feedback" id="txt" placeholder="Отзыв"
                  oninput="getTxt()"></textarea>
        <div class="rating">
            <input name="rating" type="number" placeholder="Оцените поездку от 1 до 5" required maxlength="1" minlength="5">
            <input type="submit" value="Сохранить отзыв">
        </div>
    </form>


    <script>
        function getTxt() {
            var txt = document.getElementById('txt').value;
            txt_len = txt.length;
            document.getElementById('txt1').lastChild.innerText = txt_len
        }
    </script>

</@common.htmlTemplate>


<style>
    form{
        margin-top: 20%;
        margin-left:40%;
    }
    textarea {
        background: #fffcfc;
        resize: none;
    }
    textarea {
        font-size: .8rem;
        letter-spacing: 1px;
    }
    .rating{
        margin-top: 10px;
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