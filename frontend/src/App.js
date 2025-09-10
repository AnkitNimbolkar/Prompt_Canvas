import ImageGenerator from "./components/ImageGenerator";

export default function App() {
  return (
    <div className="min-h-screen bg-gray-900 text-white">
      {/* Header */}
      <header className="bg-gradient-to-r from-indigo-600 to-purple-700 p-6 text-center shadow-lg">
        <h1 className="text-4xl font-extrabold tracking-wide">
          AI Photo Generator ✨
        </h1>
        <p className="text-gray-200 mt-2 text-lg">
          Turn your imagination into stunning images in seconds
        </p>
      </header>

      {/* Main Generator */}
      <main className="p-6">
        <ImageGenerator />
      </main>
    </div>
  );
}
