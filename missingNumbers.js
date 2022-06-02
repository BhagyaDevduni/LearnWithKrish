//let a = [21,25,29,28,22,24,27,26,30],
var array = [21,25,29,28,22,24,27,26,30],
arr = array.sort(),
  count = arr[8],
  missing = []

for (let i = arr[0]; i <= count; i++) {
  if (arr.indexOf(i) === -1) {
    missing.push(i)
  }
}
console.log(missing)