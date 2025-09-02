const fs = require("fs");
const input = fs.readFileSync("input.txt").toString().trim();
// const input = fs.readFileSync(0).toString().trim();

let result = 0;
for(let i = 0; i < input.length; i++) {
    if(i === 0) {
        result += 10;
    } else {
        result += (input[i] === input[i-1]) ? 5 : 10;
    }
}

console.log(result);
