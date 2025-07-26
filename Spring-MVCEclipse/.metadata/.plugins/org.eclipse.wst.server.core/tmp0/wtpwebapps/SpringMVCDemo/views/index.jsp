<%@page language="java" isELIgnored="false" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
        <h2>${lang} Calculator</h2>

         <form action="addAlien">
                <label for="aid">Enter id :</label>
                <input type="text" id="aid" name="aid"><br>
                <label for="aname">Enter name :</label>
                <input type="text" id="aname" name="aname"><br>
                <input type="submit" value="Submit">
            </form>

    </body>
</html>