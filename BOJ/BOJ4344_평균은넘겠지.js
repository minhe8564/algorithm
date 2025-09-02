const fs = require("fs");
// const input = fs.readFileSync("input.txt").toString().trim().split("\n");
const input = fs.readFileSync(0).toString().trim().split("\n");

const C = parseInt(input[0]);
for(let c = 1; c <= C; c++){
    const arr = input[c].split(" ").map(Number);
    const N = arr[0];
    let sum = 0;
    for(let n = 1; n <= N; n++){
        sum += arr[n];
    }

    let avg = sum/N;
    let count = 0;
    for(let n = 1; n <= N; n++){
        if(avg < arr[n]) {
            count++;
        }
    }

    const result = (count/N)*100
    console.log(result.toFixed(3) + "%");
}
