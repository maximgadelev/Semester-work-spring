<#ftl encoding='UTF-8'>
<#import "common.ftl" as common>
<@common.htmlTemplate pageName="AddCar">
    <form action="/addCar" method ="post">
        Марка:
        <input name="brand" type="text" minlength="1" maxlength="20" required/>
        <br>
        Номер Машины:
        <input name="number" type="text" minlength="6" maxlength="6" required>
        <br>
        Количество мест:
        <input name="numberOfPlaces" type="number" minlength="1" maxlength="10"  required>
        <br>
        Модель:
        <input name="model" type="text" maxlength="30" required>
        <br>
        <input type="submit" value="Добавить машину">
    </form>
</@common.htmlTemplate>