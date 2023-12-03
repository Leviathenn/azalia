/**
 * @author Leviathan
 */


const fs = require("fs");



var fString = "";

let index = fs.readdirSync("bin").length - 1;
let spArray = [];
let blyatArray = fs.readdirSync("bin");
for (let xxasd = 0; xxasd < blyatArray.length; xxasd++) {
    spArray[xxasd] = `${blyatArray[xxasd]},`;
    
}

spArray[index] = fs.readdirSync("bin")[index];

spArray.forEach(element => {
    fString += element;
});

let skinL = 
`[LoaderInfo]
FileC=${index}
Files=${fString}
`


fs.writeFileSync("bin/LOADSTAT",skinL)