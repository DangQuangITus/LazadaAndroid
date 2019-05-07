var express = require("express");
var router = express.Router();

router.get("/", (req, res) => {
    res.json({
        products: {
            pro1: "laptop HP"
        }
    });
});
module.exports = router;
