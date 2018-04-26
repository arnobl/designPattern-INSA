
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise

let studentID = 0;

function jury() {
    let currentStdID = studentID++;

    console.log(`The jury is going to deliberate about Student #${currentStdID}`);

    // We make a new promise: we promise a numeric count of this promise, starting from 1 (after waiting 3s)
    const promise = new Promise(
        // The resolver function is called with the ability to resolve or reject the promise
        (resolve, reject) => {
            console.log(`Deciding whether the student ${currentStdID} will be graduated. Complex heuristic.`);
            const willpass = Math.random() >= 0.5;

            if(willpass) {
                setTimeout(() => resolve(`very good student ${currentStdID}`), Math.random() * 3000);
            }else {
                setTimeout(() => reject(`Did not work enough! ${currentStdID}`), Math.random() * 3000);
            }
        }
    );

    promise.then(sucessMsg => console.log(`${sucessMsg} graduated!`)).catch(failMsg => console.log(`Did not graduated :s: ${failMsg}`));
}

jury();
jury();
jury();
jury();
jury();

