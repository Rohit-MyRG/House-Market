export default `
    <div class="login-container">
        <h2>Login</h2>
        <form id="login-form">
            <div class="input-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required />
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required />
            </div>
            <button type="submit">Login</button>
        </form>
        <p id="error-message" class="error"></p>
    </div>
`;
