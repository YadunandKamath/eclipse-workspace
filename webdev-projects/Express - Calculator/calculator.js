
const express = require("express");
const bodyParser = require("body-parser");

const app = express();
app.use(bodyParser.urlencoded({extended : true}));

app.get("/", function(req, res) {
    res.sendFile(__dirname + "/index.html");
});

app.post("/", function(req, res) {
    var num1 = Number(req.body.n1);
    var num2 = Number(req.body.n2);
    var result = Number(num1 + num2);
    res.send("Result = " + result);
    // res.send("Ok");
});

app.get("/bmi", function(req,res) {
    res.sendFile(__dirname + "/bmiCalculator.html");
});

app.post("/bmi", function(req,res) {
    var h = parseFloat(req.body.height);
    var w = parseFloat(req.body.weight);
    var bmi = w / (h * h);
    res.send("BMI = " + bmi);
    // res.send("bmi");
});

app.listen(3000, function() {
    console.log("Server live on Port 3000");
});