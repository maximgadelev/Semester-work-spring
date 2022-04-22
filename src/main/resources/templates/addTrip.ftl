<#ftl encoding='UTF-8'>
<#import "common.ftl" as common>
<@common.htmlTemplate pageName="AddTrip">
    <form action="/addTrip" method="post">
        Дата:
        <input name="date" type="text" maxlength="20" required/>
        <br>
        Цена:
        <input name="price" type="number" maxlength="6" required>
        <br>
        Путь:
        <input name="path" type="text" required>
        <br>
        Время:
        <input name="time" type="text" maxlength="30" required>
        <br>
        <input type="submit" value="Добавить поездку">
    </form>
</@common.htmlTemplate>