import './styles/style.css';
import './styles/divfaces.css';

import Die from './components/Die'
import Introduce from './components/Introduce'
import Timer from './components/Timer'
import Score from './components/Score'
import RollCounter from './components/RollCounter'

import { nanoid } from "nanoid"
import { useStopwatch } from 'react-timer-hook';
import Confetti from 'react-confetti'
import React from 'react'

function App() {

    /* %%%%%%%%%%%%%%%%%%%%%%%% STATES & VARIABLES %%%%%%%%%%%%%%%%%%%%%%%% */

    const stopWatch = useStopwatch({ autoStart: false });
    const [dice, setDice] = React.useState(allNewDice());
    const [tenzies, setTenzies] = React.useState(false);
    const [started, setStarted] = React.useState(false);
    const [rollCount, setRollCount] = React.useState(0);

    /* %%%%%%%%%%%%%%%%%%%%%%%% MAPPING %%%%%%%%%%%%%%%%%%%%%%%% */

    const diceElements = dice.map(die => {
        return (
            <Die
                key={die.id}
                id={die.id}
                value={die.value}
                isHeld={die.isHeld}
                holdDice={holdDice}
            />
        )
    })

    /* %%%%%%%%%%%%%%%%%%%%%%%% EFFECTS %%%%%%%%%%%%%%%%%%%%%%%% */

    React.useEffect(
        function () {
            /* IF USER FINISH THE GAME */
            const allHeld = dice.every(die => die.isHeld === true)
            const allSame = dice.every(die => die.value === dice[0].value)
            if (allHeld & allSame) {
                setTenzies(true)
                setStarted(false);
                stopWatch.pause();
            }
            /* STARTING STOPWATCH IF USER CLICK ANY DIE */
            if (started && !stopWatch.isRunning) {
                stopWatch.start();
            }
        },
        [dice, stopWatch, started]
    )

    React.useEffect(
        function () {
            if (tenzies) {
                setStarted(false)
            }
        },
        [tenzies]
    )

    /* %%%%%%%%%%%%%%%%%%%%%%%% FUNCTIONS %%%%%%%%%%%%%%%%%%%%%%%% */

    function allNewDice() {
        const newDice = []
        do {
            newDice.push(generateNewDie())
        }
        while (
            newDice.length < 10
        );
        return (newDice)
    }

    function generateNewDie() {
        return {
            id: nanoid(),
            value: Math.ceil(Math.random() * 6),
            isHeld: false,
        }
    }

    function rollDice() {
        setDice(prevDice => prevDice.map(die => {
            return die.isHeld ? die : generateNewDie()
        }))

        setRollCount(prevCount => prevCount + 1)

        if (started === false & tenzies === false) {
            setStarted(true);
        }
    }

    function holdDice(id) {
        if (started === false & tenzies === false) {
            setStarted(true);
        }

        setDice(prevDice => prevDice.map(die => {
            return die.id === id ? { ...die, isHeld: !die.isHeld } : die
        }))
    }

    function resetGame() {
        setTenzies(false)
        setDice(allNewDice())
        setRollCount(0)
        stopWatch.reset(null, false);
    }

    /* %%%%%%%%%%%%%%%%%%%%%%%% RETURN %%%%%%%%%%%%%%%%%%%%%%%% */

    return (
        <main className="main-container">
            {
                tenzies &&
                <Confetti
                    width={window.innerWidth - 2}
                    height={window.innerHeight - 2}
                />
            }
            <Introduce />
            {
                started ?
                    <div>
                        <Timer
                            seconds={stopWatch.seconds}
                            minutes={stopWatch.minutes}
                        />
                        <RollCounter
                            rollCount={rollCount}
                        />
                    </div>
                    :
                    <Score
                        stopWatch={stopWatch}
                        rollCount={rollCount}
                    />
            }

            <div className='die-container'>
                {diceElements}
            </div>

            {tenzies ? <button className="button reset-button" onClick={resetGame}>Reset Game</button> : <button className="button roll-button" onClick={rollDice}>Roll</button>}

            <p class="footer-copyright">
                © 2022 Copyright <a class="copyright-link" href="https://github.com/rishabhverma1106" target="_blank" rel="noreferrer">Rishabh Verma</a> All Rights Reserved
            </p>
        </main>
    );
}

export default App;
