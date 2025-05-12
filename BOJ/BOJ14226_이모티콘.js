/*
 * BOJ 14226 : 이모티콘
 * 메모리 : 34,680kb
 * 시간 : 348ms
 *
 * 1. 이모티콘 복사
 * 2. 이모티콘 붙여넣기
 * 3. 이모티콘 삭제
 *
 * 모든 연산은 1초 소요
 * 이모티콘 S개를 화면에 만드는데 걸리는 최소 시간
 */

const fs = require("fs");
const input = fs.readFileSync("./input.txt").toString().trim().split("\n");

const S = parseInt(input[0]); // 이모티콘 S
const queue = [[1, 0, 0]]; // screan, clipboard, time

// visited[screen][clipboard] = 화면에 있는 이모티콘 개수, 클립보드에 있는 이모티콘 개수 해당 상태
const visited = Array.from({ length: S + 1 }, () => Array(S + 1).fill(false));
visited[1][0] = true; // 초기 상태 방문 처리
let minTime = Infinity;

while (queue.length) {
  const [screen, clipboard, time] = queue.shift();

  if (screen === S) {
    minTime = Math.min(minTime, time);
    continue;
  }

  // 복사
  if (!visited[screen][screen]) {
    visited[screen][screen] = true;
    queue.push([screen, screen, time + 1]);
  }

  // 붙여넣기
  if (clipboard > 0 && screen + clipboard <= S && !visited[screen + clipboard][clipboard]) {
    visited[screen + clipboard][clipboard] = true;
    queue.push([screen + clipboard, clipboard, time + 1]);
  }

  // 삭제
  if (screen > 0 && visited[screen - 1][clipboard] === false) {
    visited[screen - 1][clipboard] = true;
    queue.push([screen - 1, clipboard, time + 1]);
  }
}

console.log(minTime);
