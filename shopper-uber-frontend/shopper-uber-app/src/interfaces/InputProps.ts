export  interface InputProps {
    type?: React.HTMLInputTypeAttribute;
    label: string;
    value: string | number;
    onChange:  React.ChangeEventHandler<HTMLInputElement>;
}                       