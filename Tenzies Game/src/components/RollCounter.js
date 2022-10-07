export default function RollCounter(props) {
    return (
        <p className="roll-counter">
            <span className="count">Roll Count : {props.rollCount}</span>
        </p>
    )
}