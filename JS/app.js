// Javascript versie van opdracht week 1

let global = 'this is the global scope';
function goingToLocalScope() {
    const local = 'this is the local scope';
    console.log(local); //log: this is the local scope
    console.log(global); //log: this is the global scope
}
console.log(local); //ReferenceError: local is not defined
console.log(global); //log: this is the global scope

goingToLocalScope();

function convertSecondsToReadableForm(seconds) {
    let years = Math.floor(seconds / (365 * 24 * 60 * 60));
    seconds %= (365 * 24 * 60 * 60);

    let months = Math.floor(seconds / (30 * 24 * 60 * 60));
    seconds %= (30 * 24 * 60 * 60);

    let days = Math.floor(seconds / (24 * 60 * 60));
    seconds %= (24 * 60 * 60);

    let hours = Math.floor(seconds / (60 * 60));
    seconds %= (60 * 60);

    let minutes = Math.floor(seconds / 60);
    seconds %= 60;

    return `${years} ${years === 1 ? "jaar" : "jaren"}, ` +
        `${months} ${months === 1 ? "maand" : "maanden"}, ` +
        `${days} ${days === 1 ? "dag" : "dagen"}, ` +
        `${hours} ${hours === 1 ? "uur" : "uren"}, ` +
        `${minutes} ${minutes === 1 ? "minuut" : "minuten"} en ` +
        `${seconds} ${seconds === 1 ? "seconde" : "seconden"}.`;
}

// Test framework
function describe(description, fn) {
    console.log("\x1b[94m", description, "\x1b[39m");
    fn();
}

function it(msg, fn) {
    process.stdout.write('\t' + msg);
    fn();
}

function expect(expr) {
    return {
        toBe: function(assertion) {
            if (expr === assertion) {
                process.stdout.write(' \x1b[32m✔\x1b[39m\n');
            } else {
                process.stdout.write(' \x1b[31m✖\x1b[39m\n');
            }
        },
    };
}

// Test cases
describe('convertSecondsToReadableForm function', function() {
    it('converts seconds to years, months, days, hours, minutes, and seconds correctly', function() {
        let result = convertSecondsToReadableForm(31536000); // 1 jaar
        expect(result).toBe("1 jaar, 0 maanden, 0 dagen, 0 uren, 0 minuten en 0 seconden.");
    });
    it('handles plural form correctly', function() {
        let result = convertSecondsToReadableForm(63072000); // 2 jaar
        expect(result).toBe("2 jaren, 0 maanden, 0 dagen, 0 uren, 0 minuten en 0 seconden.");
    });
    it('handles single and plural forms correctly in different units', function() {
        let result = convertSecondsToReadableForm(36638401); // 1 jaar 1 maand 1 dag 1 uur 1 minuut 1 seconde
        expect(result).toBe("1 jaar, 1 maand, 29 dagen, 1 uur, 20 minuten en 1 seconde.");
    });
});
