export default function Score(props) {

    function scoreComparison(score1, score2) {
        const calculatedTime1 = (score1.time.hours * 3600) + (score1.time.minutes * 3600) + score1.time.seconds
        const calculatedTime2 = (score2.time.hours * 3600) + (score2.time.minutes * 3600) + score2.time.seconds
        if (calculatedTime1 > calculatedTime2) { return score2 }
        else { return score1 }
    }

    function scoreToText(score) {
        let text = "";
        if (score.time.minutes < 1) {
            text = `${score.time.seconds} seconds / ${score.rolls} rolls`;
        } else if (score.time.minutes < 10) {
            text = `${score.time.minutes}:${score.time.seconds < 10 ? "0" : ""}${score.time.seconds} / ${score.rolls} rolls`;
        } else {
            text = "Time out";
        }
        return text
    }

    function getHighestScore() {
        return (JSON.parse(localStorage.getItem("highestScore")))
    }
    function getLastestScore() {
        return (JSON.parse(localStorage.getItem("lastestScore")))
    }
    function setHighestScore(highest) {
        localStorage.setItem("highestScore", JSON.stringify(highest))
    }
    function setLastestScore(lastest) {
        localStorage.setItem("lastestScore", JSON.stringify(lastest))
    }

    if (props.stopWatch !== 0 & props.rollCount !== 0) {
        setLastestScore(
            {
                time: props.stopWatch,
                rolls: props.rollCount
            }
        )

        if (getHighestScore() === null) {
            setHighestScore(
                {
                    time: props.stopWatch,
                    rolls: props.rollCount
                }
            )
        }
        else {
            setHighestScore(scoreComparison(getHighestScore(), getLastestScore()))
        }
    }

    const highest = getHighestScore()
    const lastest = getLastestScore()

    return (
        <div className="scores">
            {highest !== null && <p className="highest-score">Highest Score : {scoreToText(highest)}</p>}
            {lastest !== null && <p className="lastest-score">Lastest Score : {scoreToText(lastest)}</p>}
        </div>
    )
}

/*


*/