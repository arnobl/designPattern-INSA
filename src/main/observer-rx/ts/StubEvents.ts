
const MouseEvent = require("jsdom/lib/jsdom/living").MouseEvent;
const KeyboardEvent = require("jsdom/lib/jsdom/living").KeyboardEvent;

export function createMouseEvent(type: string, target: EventTarget, button : number): MouseEvent {
    return new MouseEvent(type, {
        bubbles: true,
        cancelable: false,
        detail: 1,
        screenX: 20,
        screenY: 30,
        clientX: 2,
        clientY: 3,
        ctrlKey: false,
        altKey: false,
        shiftKey: false,
        metaKey: false,
        button: button,
        relatedTarget: target
    });
}

export function createKeyEvent(type: string, keyCode: string): KeyboardEvent {
    return new KeyboardEvent(type, {
        cancelable: false,
        bubbles: true,
        code: keyCode,
        repeat: false
    });
}
