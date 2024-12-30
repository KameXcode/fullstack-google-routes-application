export  interface InputProps {
    type?: React.HTMLInputTypeAttribute;
    label: string;
    value: string | null;
    onChange:  React.ChangeEventHandler<HTMLInputElement>;
}                       