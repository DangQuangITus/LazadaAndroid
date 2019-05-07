var express = require("express"),
    bodyParser = require("body-parser"),
    morgan = require("morgan"),
    cors = require("cors"),
    dotenv = require("dotenv").config();

var app = express();
var productCtrl = require("./apiControllers/ProductController");

app.use(morgan("dev"));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cors());

app.get("/", (req, res) => {
    res.json({
        msg: "hello from nodejs express api"
    });
});

app.use("/product/", productCtrl);

var port = process.env.PORT || 5000;
app.listen(port, () => {
    console.log(`Backend API is running on port ${port}`);
});
