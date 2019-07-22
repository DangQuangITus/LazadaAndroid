var md5 = require("crypto-js/md5");
var kn = require("../fn/db");

exports.single = uid =>
    kn
        .from("product")
        .select("*")
        .where("id", parseInt(uid))
        .first();

exports.add = product =>
    kn
        .from("product")
        .insert(product)
        .returning("id");
