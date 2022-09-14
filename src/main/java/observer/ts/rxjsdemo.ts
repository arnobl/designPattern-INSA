import {fromEvent, range} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {JSDOM} from "jsdom";
import {takeWhile} from "rxjs/internal/operators";
import {createMouseEvent} from "./StubEvents";

// npm run compile
// node target/rxjsdemo.js

// A first simple example

range(1, 10)
    .pipe(filter(x => x % 2 === 1), map(x => x + x))
    .subscribe(x => console.log(x));

// Processing button events

const { document } = (new JSDOM(`...`)).window;

const button =  document.createElement("BUTTON");

const subscription = fromEvent(button, 'click')
    .subscribe((evt: MouseEvent) => console.log("click on button: " + evt.button));

button.click();
subscription.unsubscribe();

// the takeWhile routine

fromEvent(button, 'click')
    .pipe(takeWhile((evt: MouseEvent) => evt.button === 0))
    .subscribe((evt: MouseEvent) => console.log("click on button: " + evt.button));

button.dispatchEvent(createMouseEvent("click", button, 0));
button.dispatchEvent(createMouseEvent("click", button, 0));
// The button changes so that takeWhile will stop the subscription.
button.dispatchEvent(createMouseEvent("click", button, 1));
// Ignored as the subscription has stopped
button.dispatchEvent(createMouseEvent("click", button, 0));
